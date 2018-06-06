package andrew.coursework.repository;

import andrew.coursework.model.EngineeringStuff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EngineeringStuffRepository extends CrudRepository<EngineeringStuff, Integer> {

    @Query("select engineeringStuff FROM EngineeringStuff engineeringStuff where engineeringStuff.buildingManagement.id=:managementId")
    List<EngineeringStuff> selectEngineersByBuildingManagement(@Param("managementId")int managementId);


}
