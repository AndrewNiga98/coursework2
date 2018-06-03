package andrew.coursework.repository;

import andrew.coursework.model.Object;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends CrudRepository<Object, Integer>{
}
