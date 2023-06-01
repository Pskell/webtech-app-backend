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
public class ItemFromSourceController {

    private final ItemFromSourceService service;

    @Autowired
    public ItemFromSourceController(ItemFromSourceService service) {
        this.service = service;
    }


    @PostMapping("/itemFromSource")
    public ItemFromSource createItemFromSource(@RequestBody ItemFromSource itemFromSource) {
        return service.save(itemFromSource);
    }

    @GetMapping("/itemFromsource/{key}")
    public ItemFromSource getItemFromSource(@PathVariable String key) {
        Long itemFromSourceId = Long.parseLong(key);
        return service.get(itemFromSourceId);
    }

    @GetMapping("/itemFromSource")
    public List<ItemFromSource> getAllThings() {
        return service.getAll();
    }


    // Better presentation, temp. until proper UI is written
    @GetMapping(value = "/sets")
    public ResponseEntity<String> getAllThingsFormatted() throws JsonProcessingException {
        List<ItemFromSource> itemFromSources = service.getAll();
        StringJoiner joiner = new StringJoiner("\n\n");
        ObjectMapper mapper = new ObjectMapper();
        for (ItemFromSource itemFromSource : itemFromSources) {
            String itemFromSourceJson = mapper.writeValueAsString(itemFromSource);
            joiner.add(itemFromSourceJson);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(joiner.toString(), headers, HttpStatus.OK);
    }

}
