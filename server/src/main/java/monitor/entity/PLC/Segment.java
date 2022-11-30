package monitor.entity.PLC;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*Сегмент - это совокупность устройств находящихся в одной ModBus сети*/

@Table(name = "segments")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "protocol")
    private EProtocolType protocol;/* - protocol - это вид ModBus протокола по которому происходит опрос*/
    @Column(name = "port")
    private String port;/* - port - это COM порт куда физически подключен адаптер для ModBus-RTU*/
    @Column(name = "baud_rate")
    private Integer baudRate;
    @Column(name = "stop_bits")
    private String stopBits;
    @Column(name = "rs485_mode")
    private Boolean rs485Mode;
    @Column(name = "encoding")
    private String encoding;
    @Column(name = "echo")
    private Boolean echo;
    @Column(name = "tcp_port")
    private Integer tcpPort;
    @Column(name = "timeout")
    private Integer timeout;
    @OneToMany(mappedBy = "segment",fetch = FetchType.EAGER)
    private List<PlcEntity> plcEntities;

}
