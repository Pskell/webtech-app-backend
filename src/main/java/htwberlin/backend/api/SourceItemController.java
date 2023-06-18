/*


Currently unnecessary code, as champion data can be loaded dynamically from the JSON file, without the need of accessing the backend.

package htwberlin.backend.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htwberlin.backend.dbmethods.SourceItemService;
import htwberlin.backend.data.SourceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringJoiner;


@RestController
public class SourceItemController {

    private final SourceItemService service;

    @Autowired
    public SourceItemController(SourceItemService service) {
        this.service = service;
    }


    @PostMapping("/item")
    public SourceItem createItemFromSource(@RequestBody SourceItem sourceItem) {
        return service.save(sourceItem);
    }

    @PostMapping("/items")
    public Iterable<SourceItem> createItemsFromSource(@RequestBody List<SourceItem> itemsFromSource) {
        return service.saveAll(itemsFromSource);
    }

    @GetMapping("/items/{key}")
    public SourceItem getItemFromSource(@PathVariable String key) {
        Long itemFromSourceId = Long.parseLong(key);
        return service.get(itemFromSourceId);
    }



    @GetMapping("/items")
    public List<SourceItem> getAllThings() {
        return service.getAll();
    }
}
*/
