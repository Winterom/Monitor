package monitor.polling;

import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import monitor.entity.PLC.EPollingStatus;
import monitor.entity.PLC.Segment;
import monitor.exceptions.ModbusConnectionException;
import monitor.polling.command.ReadCommand;
import monitor.polling.master.ModbusRTUMasterBuilderImpl;

import java.util.Arrays;
import java.util.List;


@Setter
@Slf4j
public class PollingRTUSegmentImpl extends PollingSegment{
    private final List<PollingPlc> pollingPlcs;
    private final Segment segment;
    private ModbusSerialMaster modbusMaster;


    public PollingRTUSegmentImpl(List<PollingPlc> pollingPlcs, Segment segment) {
        this.pollingPlcs = pollingPlcs;
        this.segment = segment;
        super.setPollingStatus(EPollingStatus.SEGMENT_STOPPED);
    }


    @Override
    public Segment getSegment() {
        return this.segment;
    }

    @Override
    public List<PollingPlc> getPollingPlc() {
        return this.pollingPlcs;
    }


    @Override
    public void init() {
        this.modbusMaster = new ModbusRTUMasterBuilderImpl().build(segment);
    }

    @Override
    public void run() {
        try {
            modbusMaster.connect();
            super.setPollingStatus(EPollingStatus.SEGMENT_POLLING);
            while (true){
                for(PollingPlc plc: pollingPlcs){
                    List<ReadCommand> commands =plc.getCommands();
                    for(ReadCommand command: commands){
                        log.info(Arrays.toString(command.invokePolling(plc.getModbusAddress(), modbusMaster)));
                        if(Thread.currentThread().isInterrupted()){
                            this.close();
                            return;
                        }
                    }
                }

            }
        } catch (Exception e) {
            super.setPollingStatus(EPollingStatus.SEGMENT_STOPPED);
            throw new ModbusConnectionException("Невозможно создать соединение в сегменте: "+segment.getName()+"; "+
                    e.getMessage());
        }
    }

    public void close() throws Exception {
        if(this.modbusMaster !=null){
            this.modbusMaster.disconnect();
        }
    }


}
