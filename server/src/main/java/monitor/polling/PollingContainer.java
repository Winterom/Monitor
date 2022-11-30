package monitor.polling;

import monitor.dto.response.plc.GetAllPlcTableResponseDto;
import monitor.entity.PLC.Segment;

public interface PollingContainer {
    PollingSegment initSegment(Segment segment);
    void startSegment(Segment segment);
    void stopSegment(Segment segment);
    GetAllPlcTableResponseDto getAll();
}
