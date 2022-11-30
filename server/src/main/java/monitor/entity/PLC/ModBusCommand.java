package monitor.entity.PLC;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/*Каждая команда принадлежит какому то профилю, каждое устройство имеет профиль.
Опрос устройств происходит по каждой команде состоящей в профиле устройства*/
@Table(name = "commands")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ModBusCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;/*Описание команды для чего она предназначена*/
    @Column(name = "short_name")
    private String shortName;/*Имя команды обычно совпадает с именем переменной указанной в Modbus карте устройства*/
    @Column(name = "address")
    private Integer address; /*Физический адрес переменной (не смещение от начала таблицы а именно адрес)*/
    @Column(name = "byte_count")
    private Integer count;/*Количество регистров которое необходимо прочитать*/
    @Enumerated(EnumType.STRING)
    @Column(name = "command_type")
    private EModBusCommandType commandType;/*Modbus комманда*/
    @Column(name = "error_value")
    private String error_value;/*значение которое выдает контроллер имея ошибки*/
    @Column(name = "store")
    private Boolean store; /*Следует ли записывать историю изменений значений в базу данных*/
    @ManyToOne
    @JoinColumn(name = "profile_id")/*Какому профилю принадлежит команда*/
    private PlcProfile profile;
}
