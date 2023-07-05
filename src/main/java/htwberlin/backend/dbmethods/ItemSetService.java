package htwberlin.backend.dbmethods;

import htwberlin.backend.data.ItemSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemSetService {

    private final ItemSetRepository repo;

    @Autowired
    public ItemSetService(ItemSetRepository repo) {
        this.repo = repo;
    }

    // Return a single saved itemSet by its primary key.
    public ItemSet get(Long key) {
        return repo.findById(key).orElse(null);
    }

    // Return all saved itemSets.
    public List<ItemSet> getAll() {
        return repo.findAll();
    }

    // Delete a single saved itemSet by its primary key, return false, if it doesn't exist.
    public boolean deleteById(Long key) {
        if (!repo.existsById(key)) {
            return false;
        }
        repo.deleteById(key);
        return true;
    }

    //save an ItemSet (Validation (should) happen inside the controller class )
    public ItemSet save(ItemSet itemset) {
        return repo.save(itemset);
    }


}
