package htwberlin.backend.dbmethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import htwberlin.backend.data.ItemSet;
import java.util.List;


@Service
public class ItemSetService {

    private final ItemSetRepository repo;

    @Autowired
    public ItemSetService(ItemSetRepository repo) {
        this.repo = repo;
    }

    public ItemSet get(Long key) {
        return repo.findById(key).orElse(null);
    }

    public List<ItemSet> getAll() {
        return repo.findAll();
    }

    public void deleteById(Long key){
        repo.deleteById(key);
    }

    public ItemSet save(ItemSet itemset) {
        return repo.save(itemset);
    }





}