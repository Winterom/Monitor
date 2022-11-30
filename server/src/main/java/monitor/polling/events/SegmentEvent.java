package monitor.polling.events;

import monitor.entity.PLC.EPollingStatus;
import monitor.entity.PLC.Segment;

public class SegmentEvent {
    private final EPollingStatus status;
    private final Segment segment;
    public SegmentEvent(Segment segment,EPollingStatus status){
        this.segment = segment;
        this.status = status;
    }

    public EPollingStatus getStatus() {
        return status;
    }

    public Segment getSegment() {
        return segment;
    }
}
