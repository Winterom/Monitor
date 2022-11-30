package monitor.polling.command;

import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.facade.AbstractModbusMaster;
import com.ghgande.j2mod.modbus.procimg.Register;



public class ReadHoldingRegister extends AbstractReadCommand{
    @Override
    public byte[] polling(Integer plcAddress, AbstractModbusMaster modbusMaster) throws ModbusException {
            Register[] registers = modbusMaster.readMultipleRegisters(plcAddress,
                    getModBusCommand().getAddress(), getModBusCommand().getCount());
            return convertRegisterToByteArray(registers);
    }
    public byte[] convertRegisterToByteArray(Register[] registers){
        int totalLength=0;
        for(Register register:registers){
            totalLength = totalLength+register.toBytes().length;
        }
        int offset =0;
        byte[] result = new byte[totalLength];
        for(Register register:registers){
            byte[] array = register.toBytes();
            System.arraycopy(array,0,result,offset,array.length);
            offset = offset+array.length;
        }
        return result;
    }
}
