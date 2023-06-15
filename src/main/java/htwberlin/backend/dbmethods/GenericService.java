package htwberlin.backend.dbmethods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService<T, Long> {

    private JpaRepository<T, Long> repo;


    public GenericService(JpaRepository<T, Long> repo) {
        this.repo = repo;
    }

    public T save(T entity) {
        return repo.save(entity);
    }

    public List<T> saveAll(List<T> entities) {
        return repo.saveAll(entities);
    }

    public T get(Long key) {
        return repo.findById(key).orElseThrow(RuntimeException::new);
    }

    public List<T> getAll() {
        return repo.findAll();
    }


    // Add other common methods if needed
}
