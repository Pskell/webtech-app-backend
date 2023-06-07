package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionService extends GenericService<Champion, Long> {

    @Autowired
    public ChampionService(ChampionRepository repo) {
        super(repo);
    }
}
