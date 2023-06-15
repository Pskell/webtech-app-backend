package htwberlin.backend.dbmethods;

import htwberlin.backend.data.SourceItem;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface SourceItemRepository extends JpaRepository<SourceItem, Long> {

}
