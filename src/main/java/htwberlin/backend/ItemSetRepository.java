package htwberlin.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSetRepository extends CrudRepository<ItemSet, Long> {

}