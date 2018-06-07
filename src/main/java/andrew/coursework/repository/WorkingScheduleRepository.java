package andrew.coursework.repository;

import andrew.coursework.model.WorkingSchedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingScheduleRepository extends CrudRepository<WorkingSchedule, Integer> {
    /*@Query("select workingSchedule from WorkingSchedule workingSchedule where workingSchedule.object.area.buildingManagement.id =: managementId")
    List<WorkingSchedule> selectMachineryByManagement(@Param("managementId") int managementId);*/
    @Query("select workingSchedule from WorkingSchedule workingSchedule where workingSchedule.object.id =:objectId")
    List<WorkingSchedule> selectMachineryByObject(@Param("objectId") int objectId);
    @Query("select workingSchedule from WorkingSchedule workingSchedule where workingSchedule.object.area.buildingManagement.id=:managementId")
    List<WorkingSchedule> selectMachineryByManagement(@Param("managementId") int managementId);
}
