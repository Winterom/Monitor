package monitor.polling.command;

import com.ghgande.j2mod.modbus.facade.AbstractModbusMaster;
import monitor.entity.PLC.ModBusCommand;


public interface ReadCommand {

    byte[] invokePolling(Integer plcAddress, AbstractModbusMaster modbusMaster);
    void setModbusCommand( ModBusCommand modBusCommand);
}
