package andrew.coursework.repository;

import andrew.coursework.model.BuildingManagement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingManagementRepository extends CrudRepository<BuildingManagement, Integer> {
}
