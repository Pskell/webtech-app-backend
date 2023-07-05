package htwberlin.backend.api;


import htwberlin.backend.data.ItemSet;
import htwberlin.backend.dbmethods.ItemSetService;
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

    // Default Get-Mapping. Main function is to prevent a 404 error, when accessing the backend without any further arguments.
    @GetMapping("/")
    public String index() {
        return "Backend reached.";
    }


    // Saving a *valid* ItemSet.
    @PostMapping("/itemsets")
    public ResponseEntity<ItemSet> createItemSet(@Valid @RequestBody ItemSet itemSet) {
        var set = service.save(itemSet);
        return ResponseEntity.ok(set);
    }

    //Return a single itemset in form of a Json Object.
    @GetMapping("/itemsets/{primKey}")
    public ResponseEntity<ItemSet> getItemSet(@PathVariable String primKey) {
        Long itemSetId = Long.parseLong(primKey);
        var set = service.get(itemSetId);
        return set != null ? ResponseEntity.ok(set) : ResponseEntity.notFound().build();
    }

    //Return all itemsets in form of a list of Json Objects.
    @GetMapping("/itemsets")
    public List<ItemSet> getAllTItemSets() {
        return service.getAll();
    }

    //Delete a single itemset by primary key (via Postman / IntelliJ HTTP Client / Front-End).
    @DeleteMapping("/itemsets/{primKey}")
    public ResponseEntity<Void> deleteItemSet(@PathVariable Long primKey) {
        boolean exists = service.deleteById(primKey);
        return exists ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }


}
