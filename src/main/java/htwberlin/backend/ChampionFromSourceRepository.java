package htwberlin.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionFromSourceRepository extends JpaRepository<ChampionFromSource, Long> {

}
