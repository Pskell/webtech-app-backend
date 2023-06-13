package htwberlin.backend.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import htwberlin.backend.dbmethods.ChampionService;
import htwberlin.backend.data.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringJoiner;


@RestController
public class ChampionController {

    private final ChampionService service;

    @Autowired
    public ChampionController(ChampionService service) {
        this.service = service;
    }


    @PostMapping("/champion")
    public Champion createChampionFromSource(@RequestBody Champion champions) {
        return service.save(champions);
    }

    @PostMapping("/champions")
    public Iterable<Champion> createChampionsFromSource(@RequestBody List<Champion> champsFromSource) {
        return service.saveAll(champsFromSource);
    }

    @GetMapping("/champions/{key}")
    public Champion getChampionFromSource(@PathVariable String key) {
        Long championFromSourceId = Long.parseLong(key);
        return service.get(championFromSourceId);
    }

    @GetMapping("/champions")
    public List<Champion> getAllThings() {
        return service.getAll();
    }


    // Better presentation, temp. until proper UI is written
    @GetMapping(value = "/allchampions")
    public ResponseEntity<String> getAllThingsFormatted() throws JsonProcessingException {
        List<Champion> champions = service.getAll();
        StringJoiner joiner = new StringJoiner("\n\n");
        ObjectMapper mapper = new ObjectMapper();
        for (Champion champion : champions) {
            String championsJson = mapper.writeValueAsString(champions);
            joiner.add(championsJson);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(joiner.toString(), headers, HttpStatus.OK);
    }

}
