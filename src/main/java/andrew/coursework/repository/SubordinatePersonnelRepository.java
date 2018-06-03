package andrew.coursework.repository;

import andrew.coursework.model.SubordinatePersonnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubordinatePersonnelRepository extends CrudRepository<SubordinatePersonnel, Integer> {
}
