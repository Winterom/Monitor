package monitor.polling;

import monitor.entity.PLC.EPollingStatus;
import monitor.entity.PLC.Segment;

import java.util.List;

public abstract class PollingSegment extends Thread {
    private EPollingStatus pollingStatus;
    public abstract Segment getSegment();
    public abstract List<PollingPlc> getPollingPlc();

    public synchronized EPollingStatus getPollingStatus(){
        return this.pollingStatus;
    };
    protected synchronized void setPollingStatus(EPollingStatus pollingStatus){
        this.pollingStatus= pollingStatus;
    }
    public abstract void init();
}
