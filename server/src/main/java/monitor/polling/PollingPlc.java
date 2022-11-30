package monitor.polling;


import lombok.Data;
import monitor.entity.PLC.EPlcStatus;
import monitor.entity.PLC.PlcEntity;
import monitor.polling.command.ReadCommand;

import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class PollingPlc {
    private Long id;
    private String fullName;
    private Integer modbusAddress;
    private String ipAddress;
    private CopyOnWriteArrayList<ReadCommand> commands;
    private EPlcStatus status;

    public PollingPlc(PlcEntity entity){
        this.id = entity.getId();
        this.ipAddress = entity.getIpAddress();
        this.fullName = entity.getFullName();
        this.modbusAddress = Integer.valueOf(entity.getModbusAddress());
    }
}

