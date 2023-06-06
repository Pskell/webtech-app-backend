package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampionFromSourceService {

    private final ChampionFromSourceRepository repo;

    @Autowired
    public ChampionFromSourceService(ChampionFromSourceRepository repo) {
        this.repo = repo;
    }

    public ChampionFromSource save(ChampionFromSource champFromSource) {

        return repo.save(champFromSource);
    }

    public List<ChampionFromSource> saveAll(List<ChampionFromSource> champsFromSource) {
        return repo.saveAll(champsFromSource);
    }

    public ChampionFromSource get(Long key) {
        return repo.findById(key).orElseThrow(RuntimeException::new);
    }

    public List<ChampionFromSource> getAll() {
        Iterable<ChampionFromSource> iterator = repo.findAll();
        List<ChampionFromSource> champFromSources = new ArrayList<>();
        for (ChampionFromSource champFromSource : iterator) champFromSources.add(champFromSource);
        return champFromSources;
    }


}
