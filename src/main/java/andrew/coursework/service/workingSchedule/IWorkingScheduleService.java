package andrew.coursework.service.workingSchedule;

import andrew.coursework.model.WorkingSchedule;

import java.util.List;

public interface IWorkingScheduleService {
    List<WorkingSchedule> getAll();
    WorkingSchedule insert(WorkingSchedule workingSchedule);
    WorkingSchedule update(WorkingSchedule workingSchedule);
    WorkingSchedule getById(int id);
    void delete(int id);
}
