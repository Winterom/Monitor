package monitor.services;

import monitor.entity.PLC.ModBusCommand;
import monitor.entity.PLC.PlcEntity;
import monitor.repositories.ModbusCommandRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class ModbusCommandService {
    private final String QUERY_GET_COMMAND_BY_PLC="select command from PlcEntity as " +
            "com left join com.profile as pr left join pr.commands as command where com.id=:plc_id";
    private final ModbusCommandRepository repository;
    private final EntityManager entityManager;

    public ModbusCommandService(ModbusCommandRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    public List<ModBusCommand> getCommandByPlc(PlcEntity plc){
        Query query =entityManager.createQuery(QUERY_GET_COMMAND_BY_PLC);
        query.setParameter("plc_id",plc.getId());
        return query.getResultList();
    }
}
