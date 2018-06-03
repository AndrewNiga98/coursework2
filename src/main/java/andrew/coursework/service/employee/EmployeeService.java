package andrew.coursework.service.employee;

import andrew.coursework.model.Employee;
import andrew.coursework.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository repository;
    @Override
    public List<Employee> getAll() {
        return (List<Employee>)repository.findAll();
    }

    @Override
    public Employee insert(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
