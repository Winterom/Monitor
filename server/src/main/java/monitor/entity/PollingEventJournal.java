package monitor.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monitor.entity.PLC.PlcEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "plc_event_journal")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PollingEventJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "plc_id")
    private PlcEntity plc;

    @Column(name = "value")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] rawValue;

    @Column(name = "description")
    private String description;

}
