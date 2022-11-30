package monitor.repositories;

import monitor.entity.PLC.ModBusCommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModbusCommandRepository extends JpaRepository<ModBusCommand,Long> {

}
