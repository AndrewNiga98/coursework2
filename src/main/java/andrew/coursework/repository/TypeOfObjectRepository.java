package andrew.coursework.repository;

import andrew.coursework.model.TypeOfObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfObjectRepository extends CrudRepository<TypeOfObject,Integer> {
}
