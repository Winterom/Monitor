package monitor.services;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import monitor.dto.response.segments.SegmentResponseDto;
import monitor.entity.PLC.Segment;
import monitor.repositories.SegmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@Getter
@Slf4j
public class SegmentService {
    private final String QUERY_GET_SEGMENT_LIST="SELECT " +
            "new monitor.dto.response.segments.SegmentResponseDto(seg, count(seg.plcEntities)) from Segment as seg";
    private final SegmentRepository segmentRepository;
    private final EntityManager entityManager;


    public SegmentService(SegmentRepository segmentRepository, EntityManager entityManager) {
        this.segmentRepository = segmentRepository;
        this.entityManager = entityManager;
    }
    public List<Segment> findAll(){
        return segmentRepository.findAll();
    }

    @Transactional
    public List<SegmentResponseDto> getAllSegments(){
        Query query =entityManager.createQuery(QUERY_GET_SEGMENT_LIST);
        return query.getResultList();
    }

}
