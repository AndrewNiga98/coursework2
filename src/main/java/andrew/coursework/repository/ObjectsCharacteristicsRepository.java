package andrew.coursework.repository;

import andrew.coursework.model.Objects_characteristics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectsCharacteristicsRepository extends CrudRepository<Objects_characteristics, Integer> {
}
