package htwberlin.backend.dbmethods;

import htwberlin.backend.data.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionService extends GenericService<Champion, Long> {

    @Autowired
    public ChampionService(ChampionRepository repo) {
        super(repo);
    }



/*  Get champion image from id, to be loaded for the vue app when importing an itemset.
    Need to create get Request as well.
  public String getImage(Long){

    }*/
}
