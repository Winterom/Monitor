package monitor.dto.response.segments;

import lombok.Data;
import monitor.entity.PLC.EProtocolType;
import monitor.entity.PLC.Segment;

@Data
public class SegmentResponseDto {
    private Long id;
    private String name;
    private EProtocolType protocol;
    private Integer baudRate;
    private String stopBits;
    private Boolean rs485Mode;
    private String encoding;
    private Boolean echo;
    private Integer tcpPort;
    private Integer timeout;
    private Long countPlc;/*Количество контроллеров в сегменте*/

    public SegmentResponseDto(Segment segment,Long countPlc){
        this.id= segment.getId();
        this.name = segment.getName();
        this.protocol = segment.getProtocol();
        this.protocol = segment.getProtocol();
        this.baudRate = segment.getBaudRate();
        this.stopBits = segment.getStopBits();
        this.rs485Mode = segment.getRs485Mode();
        this.encoding = segment.getEncoding();
        this.echo = segment.getEcho();
        this.tcpPort = segment.getTcpPort();
        this.timeout = segment.getTimeout();
        this.countPlc = countPlc;
    }
}
