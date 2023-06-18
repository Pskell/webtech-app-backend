package htwberlin.backend.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htwberlin.backend.dbmethods.ItemSetService;
import htwberlin.backend.data.ItemSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringJoiner;


@RestController
public class ItemSetController {

    private final ItemSetService service;

    @Autowired
    public ItemSetController(ItemSetService service) {
        this.service = service;
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

}
