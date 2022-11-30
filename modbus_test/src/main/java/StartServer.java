import com.ghgande.j2mod.modbus.Modbus;
import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import com.ghgande.j2mod.modbus.net.AbstractSerialConnection;
import com.ghgande.j2mod.modbus.procimg.InputRegister;
import com.ghgande.j2mod.modbus.util.BitVector;
import com.ghgande.j2mod.modbus.util.SerialParameters;


public class StartServer {

    public static void main(String[] args) throws Exception {
        System.out.println("start....");
        SerialParameters parameters = new SerialParameters();
        parameters.setPortName("/dev/tty.usbserial-A50285BI");
        parameters.setStopbits(AbstractSerialConnection.TWO_STOP_BITS);
        parameters.setBaudRate(115200);
        parameters.setRs485Mode(true);
        parameters.setRs485DelayAfterTxMicroseconds(120);
        parameters.setRs485DelayBeforeTxMicroseconds(10);
        parameters.setEncoding(Modbus.SERIAL_ENCODING_RTU);
        parameters.setFlowControlIn(AbstractSerialConnection.FLOW_CONTROL_DISABLED);
        parameters.setEcho(false);
        System.out.println(parameters);
        ModbusSerialMaster master = new ModbusSerialMaster(parameters);
        master.connect();
        try {
            BitVector registers=master.readInputDiscretes(20,
                    0x3801, 1);
            System.out.println(registers);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("завершение....");
        master.disconnect();
    }
}
