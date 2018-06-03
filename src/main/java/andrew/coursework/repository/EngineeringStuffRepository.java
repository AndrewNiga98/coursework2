package andrew.coursework.repository;

import andrew.coursework.model.EngineeringStuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineeringStuffRepository extends CrudRepository<EngineeringStuff, Integer> {
}
