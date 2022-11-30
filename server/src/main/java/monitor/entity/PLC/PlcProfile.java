package monitor.entity.PLC;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
/*Профиль - это перечень ModBus комманд которые будут выполняться в процессе опроса
* каждое устройство имеет свой профиль, у одинаковый устройств профиль может быть так же одинаковым*/
@Table(name = "plc_profiles")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PlcProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "profile")
    private List<ModBusCommand> commands;
    @OneToMany(mappedBy = "profile")
    private List<PlcEntity> plcEntities;
}
