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
public class ChampionFromSourceController {

    private final ChampionFromSourceService service;

    @Autowired
    public ChampionFromSourceController(ChampionFromSourceService service) {
        this.service = service;
    }


    @PostMapping("/champion")
    public ChampionFromSource createChampionFromSource(@RequestBody ChampionFromSource championFromSource) {
        return service.save(championFromSource);
    }

    @PostMapping("/champions")
    public Iterable<ChampionFromSource> createChampionsFromSource(@RequestBody List<ChampionFromSource> champsFromSource) {
        return service.saveAll(champsFromSource);
    }

    @GetMapping("/champions/{key}")
    public ChampionFromSource getChampionFromSource(@PathVariable String key) {
        Long championFromSourceId = Long.parseLong(key);
        return service.get(championFromSourceId);
    }

    @GetMapping("/champions")
    public List<ChampionFromSource> getAllThings() {
        return service.getAll();
    }


    // Better presentation, temp. until proper UI is written
    @GetMapping(value = "/allchampions")
    public ResponseEntity<String> getAllThingsFormatted() throws JsonProcessingException {
        List<ChampionFromSource> championFromSources = service.getAll();
        StringJoiner joiner = new StringJoiner("\n\n");
        ObjectMapper mapper = new ObjectMapper();
        for (ChampionFromSource championFromSource : championFromSources) {
            String championFromSourceJson = mapper.writeValueAsString(championFromSource);
            joiner.add(championFromSourceJson);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(joiner.toString(), headers, HttpStatus.OK);
    }

}
