package monitor.repositories;


import monitor.entity.PLC.PlcEntity;
import monitor.entity.PLC.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlcRepository extends JpaRepository<PlcEntity,Long> {
    List<PlcEntity>findAllBySegment(Segment segment);
}
