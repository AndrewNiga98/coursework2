package andrew.coursework.repository;

import andrew.coursework.model.Estimate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateRepository extends CrudRepository<Estimate, Integer>{
}
