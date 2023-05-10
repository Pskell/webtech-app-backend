package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemSetService {

    private final ItemSetRepository repo;

    @Autowired
    public ItemSetService(ItemSetRepository repo) {
        this.repo = repo;
    }

    public ItemSet save(ItemSet itemSet) {

        return repo.save(itemSet);
    }

    public ItemSet get(Long primKey) {
        return repo.findById(primKey).orElseThrow(RuntimeException::new);
    }

    public List<ItemSet> getAll() {
        Iterable<ItemSet> iterator = repo.findAll();
        List<ItemSet> itemSets = new ArrayList<>();
        for (ItemSet itemSet : iterator) itemSets.add(itemSet);
        return itemSets;
    }


}
