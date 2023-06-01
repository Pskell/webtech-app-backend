package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemFromSourceService {

    private final ItemFromSourceRepository repo;

    @Autowired
    public ItemFromSourceService(ItemFromSourceRepository repo) {
        this.repo = repo;
    }

    public ItemFromSource save(ItemFromSource itemFromSource) {

        return repo.save(itemFromSource);
    }

    public List<ItemFromSource> saveAll(List<ItemFromSource> itemsFromSource) {
        return repo.saveAll(itemsFromSource);
    }

    public ItemFromSource get(Long key) {
        return repo.findById(key).orElseThrow(RuntimeException::new);
    }

    public List<ItemFromSource> getAll() {
        Iterable<ItemFromSource> iterator = repo.findAll();
        List<ItemFromSource> itemFromSources = new ArrayList<>();
        for (ItemFromSource itemFromSource : iterator) itemFromSources.add(itemFromSource);
        return itemFromSources;
    }


}
