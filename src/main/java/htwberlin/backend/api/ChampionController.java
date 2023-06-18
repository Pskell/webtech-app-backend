/*

Currently unnecessary code, as champion data can be loaded dynamically from the JSON file, without the need of accessing the backend.

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
}
*/
