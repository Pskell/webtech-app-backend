package htwberlin.backend;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface SourceItemRepository extends JpaRepository<SourceItem, Long> {

}
