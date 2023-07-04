package htwberlin.backend.api;



import htwberlin.backend.dbmethods.ItemSetService;
import htwberlin.backend.data.ItemSet;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class ItemSetController {

    private final ItemSetService service;

    @Autowired
    public ItemSetController(ItemSetService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @PostMapping("/itemsets")
    public ItemSet createItemSet(@RequestBody ItemSet itemSet) {
        return service.save(itemSet);
    }

    @GetMapping("/itemsets/{primKey}")
    public ResponseEntity<ItemSet> getItemSet(@PathVariable String primKey) {
        Long itemSetId = Long.parseLong(primKey);
        var set = service.get(itemSetId);
        return set != null? ResponseEntity.ok(set) : ResponseEntity.notFound().build();
    }
    @GetMapping("/itemsets")
    public List<ItemSet> getAllTItemSets() {
        return service.getAll();
    }

    @DeleteMapping("/itemsets/{primKey}")
    public void deleteItemSet(@PathVariable Long primKey) {
        service.deleteById(primKey);
    }


}
