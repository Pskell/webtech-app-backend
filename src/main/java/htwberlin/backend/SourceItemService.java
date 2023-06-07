package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SourceItemService extends GenericService<SourceItem, Long> {

    @Autowired
    public SourceItemService(SourceItemRepository repo) {
        super(repo);
    }

}
