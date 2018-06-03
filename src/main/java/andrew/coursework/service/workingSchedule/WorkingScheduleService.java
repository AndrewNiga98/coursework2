package andrew.coursework.service.workingSchedule;

import andrew.coursework.model.WorkingSchedule;
import andrew.coursework.repository.WorkingScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingScheduleService implements IWorkingScheduleService{

    @Autowired
    WorkingScheduleRepository repository;
    @Override
    public List<WorkingSchedule> getAll() {
        return (List<WorkingSchedule>)repository.findAll();
    }

    @Override
    public WorkingSchedule insert(WorkingSchedule workingSchedule) {
        return repository.save(workingSchedule);
    }

    @Override
    public WorkingSchedule update(WorkingSchedule workingSchedule) {
        return repository.save(workingSchedule);
    }

    @Override
    public WorkingSchedule getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
