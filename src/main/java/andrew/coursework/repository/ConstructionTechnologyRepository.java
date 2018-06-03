package andrew.coursework.repository;

import andrew.coursework.model.ConstructionTechnology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionTechnologyRepository extends CrudRepository<ConstructionTechnology, Integer> {
}
