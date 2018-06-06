package andrew.coursework.repository;

import andrew.coursework.model.BuildingManagement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BuildingManagementRepository extends CrudRepository<BuildingManagement, Integer> {

   @Query("select management from BuildingManagement management")
    List<BuildingManagement> getAll1();

}
