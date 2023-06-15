package htwberlin.backend.dbmethods;

import htwberlin.backend.data.ItemSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemSetService extends GenericService<ItemSet, Long> {
    @Autowired
    public ItemSetService(ItemSetRepository repo) {
        super(repo);
    }
}
