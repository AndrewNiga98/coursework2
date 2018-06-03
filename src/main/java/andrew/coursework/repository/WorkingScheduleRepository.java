package andrew.coursework.repository;

import andrew.coursework.model.WorkingSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingScheduleRepository extends CrudRepository<WorkingSchedule, Integer> {
}
