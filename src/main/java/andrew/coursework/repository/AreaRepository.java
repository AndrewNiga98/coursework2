package andrew.coursework.repository;

import andrew.coursework.model.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
}
