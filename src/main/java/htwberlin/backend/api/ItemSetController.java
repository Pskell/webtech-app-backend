package htwberlin.backend.api;



import htwberlin.backend.data.Item;
import htwberlin.backend.dbmethods.ItemSetService;
import htwberlin.backend.data.ItemSet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@Validated
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
    public ResponseEntity<ItemSet> createItemSet(@Valid @RequestBody ItemSet itemSet) {
        var set = service.save(itemSet);
        return ResponseEntity.ok(set);
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
    public ResponseEntity<Void> deleteItemSet(@PathVariable Long primKey) {
        boolean exists= service.deleteById(primKey);
        return exists ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }


}
