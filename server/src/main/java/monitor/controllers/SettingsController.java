package monitor.controllers;

import monitor.dto.response.settings.SettingsOrganizationNameDto;

import monitor.services.SettingsService;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SettingsController {
    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @SubscribeMapping("settings/last")
    public SettingsOrganizationNameDto getLastSettings(){
        return new SettingsOrganizationNameDto(settingsService.getLastSettings().getOrganizationName());
    }
}
