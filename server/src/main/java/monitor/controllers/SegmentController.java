package monitor.controllers;

import monitor.dto.response.segments.SegmentResponseDto;
import monitor.services.SegmentService;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SegmentController {
    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @SubscribeMapping("segments/table")
    public List<SegmentResponseDto> getAllSegments(){
       return segmentService.getAllSegments();
    }
}
