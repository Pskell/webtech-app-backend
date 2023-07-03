package htwberlin.backend.api;



import htwberlin.backend.dbmethods.ItemSetService;
import htwberlin.backend.data.ItemSet;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ItemSet getItemSet(@PathVariable String primKey) {
        Long itemSetId = Long.parseLong(primKey);
        return service.get(itemSetId);
    }

    @GetMapping("/itemsets")
    public List<ItemSet> getAllThings() {
        return service.getAll();
    }

    @DeleteMapping("/itemsets/{primKey}")
    public void deleteItemSet(@PathVariable Long primKey) {
        service.deleteById(primKey);
    }


}
