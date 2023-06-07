package htwberlin.backend;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    // Better presentation, temp. until proper UI is written
    @GetMapping(value = "/allitems")
    public ResponseEntity<String> getAllThingsFormatted() throws JsonProcessingException {
        List<SourceItem> sourceItems = service.getAll();
        StringJoiner joiner = new StringJoiner("\n\n");
        ObjectMapper mapper = new ObjectMapper();
        for (SourceItem sourceItem : sourceItems) {
            String itemFromSourceJson = mapper.writeValueAsString(sourceItem);
            joiner.add(itemFromSourceJson);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(joiner.toString(), headers, HttpStatus.OK);
    }

}
