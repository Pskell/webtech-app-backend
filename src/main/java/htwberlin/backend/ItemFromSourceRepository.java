package htwberlin.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFromSourceRepository extends JpaRepository<ItemFromSource, Long> {

}
