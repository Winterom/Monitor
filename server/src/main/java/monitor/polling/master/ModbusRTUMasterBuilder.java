package monitor.polling.master;


import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import monitor.entity.PLC.Segment;

public interface ModbusRTUMasterBuilder {
    ModbusRTUMasterBuilder setPortName(String portName);
    ModbusRTUMasterBuilder setStopBits(String stopBits);
    ModbusRTUMasterBuilder setBaudRate(Integer baudRate);
    ModbusRTUMasterBuilder setRs485Mode(Boolean rs485Mode);
    ModbusRTUMasterBuilder setEncoding(String encoding);
    ModbusRTUMasterBuilder setEcho(Boolean echo);
    ModbusRTUMasterBuilder setTimeout(Integer timeout);
    ModbusSerialMaster build();
    ModbusSerialMaster build(Segment segment);
}
