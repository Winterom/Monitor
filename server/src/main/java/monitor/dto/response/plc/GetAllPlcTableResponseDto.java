package monitor.dto.response.plc;

import lombok.Getter;
import lombok.Setter;
import monitor.entity.PLC.EPlcStatus;
import monitor.entity.PLC.EPollingStatus;
import monitor.polling.PollingPlc;
import monitor.polling.PollingSegment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Getter
@Setter
public class GetAllPlcTableResponseDto {
    private List<SegmentsDto> segments;

    public GetAllPlcTableResponseDto (ConcurrentHashMap<Long, PollingSegment> container){
        List<PollingSegment> pollingSegmentList = new ArrayList<>(container.values());
        this.segments = pollingSegmentList.stream().map(SegmentsDto::new).collect(Collectors.toList());

    }

    @Getter
    @Setter
    public static class SegmentsDto{
        private Long id;
        private String name;
        private List<PlcDto> plcList;
        private EPollingStatus pollingStatus;

        public SegmentsDto(PollingSegment pollingSegment){
            this.id = pollingSegment.getSegment().getId();
            this.name =pollingSegment.getSegment().getName();
            this.pollingStatus = pollingSegment.getPollingStatus();
            this.plcList = pollingSegment.getPollingPlc().stream().map(PlcDto::new).collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    public static class PlcDto{
        private Long id;
        private String fullName;
        private Integer modbusAddress;
        private EPlcStatus status;

        public PlcDto(PollingPlc plc){
            this.id = plc.getId();
            this.modbusAddress = plc.getModbusAddress();
            this.fullName = plc.getFullName();
            this.status = plc.getStatus();
        }
    }
}
