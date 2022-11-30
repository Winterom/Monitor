package monitor.services;

import monitor.entity.Settings;
import monitor.repositories.SettingsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class SettingsService {
    private final SettingsRepository settingsRepository;
    private final EntityManager entityManager;
    private final String GET_LAST_CREATED="SELECT s from Settings as s order by s.created desc";

    public SettingsService(SettingsRepository settingsRepository, EntityManager entityManager) {
        this.settingsRepository = settingsRepository;
        this.entityManager = entityManager;
    }

    public Settings getLastSettings(){
        Query query = entityManager.createQuery(GET_LAST_CREATED);
        List<Settings> queryResult =  query.setMaxResults(1).getResultList();
        if(queryResult.isEmpty()){
            return new Settings();
        }
        return queryResult.get(0);
    }

}
