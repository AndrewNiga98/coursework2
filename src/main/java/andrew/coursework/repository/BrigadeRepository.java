package andrew.coursework.repository;

import andrew.coursework.model.Brigade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadeRepository extends CrudRepository<Brigade, Integer> {

}
