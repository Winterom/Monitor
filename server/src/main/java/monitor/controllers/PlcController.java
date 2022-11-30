package monitor.controllers;


import monitor.dto.response.plc.GetAllPlcTableResponseDto;
import monitor.polling.PollingContainer;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;


@Controller
public class PlcController {

    private final PollingContainer pollingContainer;

    public PlcController(PollingContainer pollingContainer) {
        this.pollingContainer = pollingContainer;
    }

    @SubscribeMapping("/plc/table")
    public GetAllPlcTableResponseDto getPlcTable(){
        return pollingContainer.getAll();
    }

}
