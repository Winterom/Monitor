package monitor.repositories;

import monitor.entity.PLC.PlcProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<PlcProfile,Long> {

}
