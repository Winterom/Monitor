package monitor.polling;


import monitor.entity.PLC.EPollingStatus;
import monitor.entity.PLC.Segment;

import java.util.List;

public class PollingTCPSegmentImpl extends PollingSegment {
    private final List<PollingPlc> pollingPlcs;
    private final Segment segment;

    public PollingTCPSegmentImpl(List<PollingPlc> pollingPlcs, Segment segment) {
        this.pollingPlcs = pollingPlcs;
        this.segment = segment;
        super.setPollingStatus(EPollingStatus.SEGMENT_STOPPED);
    }

    @Override
    public Segment getSegment() {
       return  this.segment;
    }

    @Override
    public List<PollingPlc> getPollingPlc() {
        return this.pollingPlcs;
    }

    @Override
    public void init() {

    }

    @Override
    public void run() {
        while (true){
            super.setPollingStatus(EPollingStatus.SEGMENT_POLLING);
            if(Thread.currentThread().isInterrupted()){
                return;
            }
        }
    }
}
