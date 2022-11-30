package monitor.utils;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SerialPortsImpl implements SerialPorts{
    private List<String> ports;

    @PostConstruct
    public void updatePortList(){
        this.ports = new CopyOnWriteArrayList<>();
        SerialPort[] portsL = SerialPort.getCommPorts();
        if (ports != null && portsL.length > 0) {
            for (SerialPort port : portsL) {
               ports.add(port.getSystemPortName());
            }
        }
    }

    @Override
    public List<String> getSerialPorts() {
        return this.ports;
    }
}
