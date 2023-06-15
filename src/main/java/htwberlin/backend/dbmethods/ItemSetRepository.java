package htwberlin.backend.dbmethods;

import htwberlin.backend.data.ItemSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSetRepository extends JpaRepository<ItemSet, Long> {

}
