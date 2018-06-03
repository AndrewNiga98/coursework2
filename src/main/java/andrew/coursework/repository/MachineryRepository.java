package andrew.coursework.repository;

import andrew.coursework.model.Machinery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineryRepository extends CrudRepository<Machinery, Integer> {
}
