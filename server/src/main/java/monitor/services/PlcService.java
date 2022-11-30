package monitor.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monitor.entity.PLC.PlcEntity;
import monitor.entity.PLC.Segment;
import monitor.repositories.PlcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class PlcService {
    private PlcRepository repository;

    public List<PlcEntity> findAllPlcInSegment(Segment segment){
        return repository.findAllBySegment(segment);
    }
}
