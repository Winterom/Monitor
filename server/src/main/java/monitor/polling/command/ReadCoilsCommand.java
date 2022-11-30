package monitor.polling.command;

import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.facade.AbstractModbusMaster;
import lombok.Getter;



@Getter
public class ReadCoilsCommand extends AbstractReadCommand  {

    public byte[] polling(Integer plcAddress, AbstractModbusMaster modbusMaster) throws ModbusException {
             return modbusMaster.readCoils(
                    plcAddress, getModBusCommand().getAddress(), getModBusCommand().getCount()
            ).getBytes();
    }

}
