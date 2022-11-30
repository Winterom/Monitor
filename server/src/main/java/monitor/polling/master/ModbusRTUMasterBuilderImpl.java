package monitor.polling.master;

import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import com.ghgande.j2mod.modbus.util.SerialParameters;
import monitor.entity.PLC.Segment;

public class ModbusRTUMasterBuilderImpl implements ModbusRTUMasterBuilder{
    private final SerialParameters parameters = new SerialParameters();
    private Integer timeout = 3000;

    @Override
    public ModbusRTUMasterBuilder setPortName(String portName) {
        this.parameters.setPortName(portName);
        return this;
    }

    @Override
    public ModbusRTUMasterBuilder setStopBits(String stopBits) {
        this.parameters.setStopbits(stopBits);
        return this;
    }

    @Override
    public ModbusRTUMasterBuilder setBaudRate(Integer baudRate) {
        this.parameters.setBaudRate(baudRate);
        return  this;
    }

    @Override
    public ModbusRTUMasterBuilder setRs485Mode(Boolean rs485Mode) {
        this.parameters.setRs485Mode(rs485Mode);
        return  this;
    }

    @Override
    public ModbusRTUMasterBuilder setEncoding(String encoding) {
        this.parameters.setEncoding(encoding);
        return  this;
    }

    @Override
    public ModbusRTUMasterBuilder setEcho(Boolean echo) {
        this.parameters.setEcho(echo);
        return  this;
    }

    @Override
    public ModbusRTUMasterBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return  this;
    }

    @Override
    public ModbusSerialMaster build() {
        ModbusSerialMaster master = new ModbusSerialMaster(parameters);
        master.setTimeout(timeout);
        return master;
    }

    @Override
    public ModbusSerialMaster build(Segment segment) {
        parameters.setPortName(segment.getPort());
        parameters.setStopbits(segment.getStopBits());
        parameters.setBaudRate(segment.getBaudRate());
        parameters.setRs485Mode(segment.getRs485Mode());
        parameters.setEncoding(segment.getEncoding());
        parameters.setEcho(segment.getEcho());
        ModbusSerialMaster master = new ModbusSerialMaster(parameters);
        master.setTimeout(segment.getTimeout());
        return master;
    }


}
