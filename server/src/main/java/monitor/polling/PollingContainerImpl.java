package monitor.polling;


import lombok.Getter;
import lombok.Setter;
import monitor.dto.response.plc.GetAllPlcTableResponseDto;
import monitor.entity.PLC.EPlcStatus;
import monitor.entity.PLC.EPollingStatus;
import monitor.entity.PLC.PlcEntity;
import monitor.entity.PLC.Segment;
import monitor.exceptions.ResourceNotFoundException;
import monitor.exceptions.SegmentPollingException;
import monitor.polling.command.Command;
import monitor.polling.command.ReadCommand;
import monitor.polling.events.SegmentEvent;
import monitor.services.ModbusCommandService;
import monitor.services.SegmentService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
public class PollingContainerImpl implements PollingContainer{
    private final SegmentService segmentService;
    private final ModbusCommandService commandService;
    private final Command command;
    private final ConcurrentHashMap<Long,PollingSegment> pollingSegments = new ConcurrentHashMap<>();
    private final ApplicationEventPublisher applicationEventPublisher;

    public PollingContainerImpl(SegmentService segmentService, ModbusCommandService commandService, Command command, ApplicationEventPublisher applicationEventPublisher) {
        this.segmentService = segmentService;
        this.commandService = commandService;
        this.command = command;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostConstruct
    public void initialization(){
        List<Segment> segments = segmentService.findAll();
        for (Segment segment:segments){
            initSegment(segment);
        }
    }
    public PollingSegment initSegment(Segment segment){
        PollingSegment pollingSegment = pollingSegments.get(segment.getId());
        if(pollingSegment!=null){
            if(pollingSegment.isAlive()){
                throw new SegmentPollingException("Невозможно обновить данные в сегменте: "+segment.getName()+ " пока выполняется опрос");
            }
            pollingSegments.remove(segment.getId());
        }
        List<PlcEntity> plcEntityList= segment.getPlcEntities();
        List<PollingPlc> pollingPlcList = new ArrayList<>();
        for(PlcEntity plcEntity: plcEntityList){
            List<ReadCommand> readCommands = commandService.getCommandByPlc(plcEntity).stream().map(command::getCommand).collect(Collectors.toList());
            PollingPlc pollingPlc = new PollingPlc(plcEntity);
            pollingPlc.setCommands(new CopyOnWriteArrayList<>(readCommands));
            pollingPlc.setStatus(EPlcStatus.UNAVAILABLE);
            pollingPlcList.add(pollingPlc);
        }
        pollingSegment = new PollingRTUSegmentImpl(pollingPlcList,segment);
        pollingSegment.init();
        this.pollingSegments.put(segment.getId(),pollingSegment);
        return pollingSegment;
    }
    /*TODO event должен отрабатывать по факту успешного старта и по факту завершения потока*/

    public void startSegment(Segment segment){
        PollingSegment pollingSegment = pollingSegments.get(segment.getId());
        if(pollingSegment!=null) {
            if (pollingSegment.isAlive()) {
                return;
            }
            if (!pollingSegment.getState().equals(Thread.State.NEW)) {
                pollingSegment = this.initSegment(segment);
                pollingSegments.put(segment.getId(), pollingSegment);
            }
            pollingSegment.setDaemon(true);
            pollingSegment.start();
            this.applicationEventPublisher.publishEvent(new SegmentEvent(segment, EPollingStatus.SEGMENT_POLLING));
        }else {
            throw new ResourceNotFoundException("Сегмент не найден: " +segment);
        }
    }

    public void stopSegment(Segment segment){
        PollingSegment pollingSegment = pollingSegments.get(segment.getId());
        if(pollingSegment!=null) {
            if(pollingSegment.isAlive()){
                pollingSegment.interrupt();
                this.applicationEventPublisher.publishEvent(new SegmentEvent(segment, EPollingStatus.SEGMENT_STOPPED));
            }
        }
    }

    @Override
    public GetAllPlcTableResponseDto getAll() {
        return new GetAllPlcTableResponseDto(this.pollingSegments);
    }


}
