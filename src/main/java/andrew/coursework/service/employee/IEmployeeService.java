package andrew.coursework.service.employee;

import andrew.coursework.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();
    Employee insert(Employee employee);
    Employee update(Employee employee);
    Employee getById(int id);
    void delete(int id);
}
