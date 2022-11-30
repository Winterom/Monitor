package monitor.polling.command;


import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.facade.AbstractModbusMaster;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import monitor.entity.PLC.ModBusCommand;

@Getter
@Setter
@Slf4j
public abstract class AbstractReadCommand implements ReadCommand{
    private ModBusCommand modBusCommand;

    @Override
    public byte[] invokePolling(Integer plcAddress, AbstractModbusMaster modbusMaster) {
        try {
            return this.polling(plcAddress, modbusMaster);
        } catch (ModbusException e) {
          return null;
        }

    }

    @Override
    public void setModbusCommand(ModBusCommand modBusCommand) {
        this.modBusCommand = modBusCommand;
    }

    protected abstract byte[] polling(Integer plcAddress, AbstractModbusMaster modbusMaster) throws ModbusException;

}
