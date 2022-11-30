package monitor.polling.command;

import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.facade.AbstractModbusMaster;

public class ReadInputsRegister extends AbstractReadCommand{


    @Override
    public byte[] polling(Integer plcAddress, AbstractModbusMaster modbusMaster) throws ModbusException {
            return modbusMaster.readInputDiscretes(plcAddress,
                    getModBusCommand().getAddress(), getModBusCommand().getCount()).getBytes();
    }
}
