package monitor.entity.PLC;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monitor.entity.PollingEventJournal;

import javax.persistence.*;
import java.util.List;


/*Класс описывающий сущность программируемого логического контроллера (ПЛК)*/
@Table(name = "controllers")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PlcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "address")
    private Short modbusAddress;
    @Column(name = "ip_address")
    private String ipAddress;
    @Enumerated(EnumType.STRING)
    @Column(name = "protocol")
    private EProtocolType protocol;
    @ManyToOne
    @JoinColumn(name = "segment_id")
    private Segment segment;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private PlcProfile profile;
    @OneToMany(mappedBy = "plc")
    private List<PollingEventJournal> eventJournals;
}
