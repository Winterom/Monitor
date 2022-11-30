package monitor.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


@Component
@Data
public class BrowserLauncher {
    private Desktop desktop;
    private final String CLIENT_URL="http://localhost:8080/";
    @PostConstruct
    public void openBrowser(){
        System.setProperty("java.awt.headless", "false");
        try {
            desktop = Desktop.getDesktop();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Класс Desktop не поддерживается.");
            return;
        }
        if (!desktop.isSupported(Desktop.Action.BROWSE)) {
            System.err.println("BROWSE: операция не поддерживается..");
            return;
        }
        // если все ок пытаемся открыть ссылку
        try {
            desktop.browse(new URL(CLIENT_URL).toURI());
        } catch (IOException | URISyntaxException ex) {
            System.err.println("Failed to browse. " + ex.getLocalizedMessage());
        }
    }
}
