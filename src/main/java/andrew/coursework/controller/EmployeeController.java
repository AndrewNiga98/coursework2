package andrew.coursework.controller;

import andrew.coursework.model.Brigade;
import andrew.coursework.model.Employee;
import andrew.coursework.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @RequestMapping("/employee")
    public List<Employee> getAll()
    {
        List<Employee> list = service.getAll();
        list= list.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
        return service.getAll();
    }

    @RequestMapping("/employee/get")
    public Employee getById(@RequestParam int id)
    {
        return service.getById(id);
    }

    @RequestMapping("/employee/del")
    public void delete(@RequestParam int id)
    {
        service.delete(id);
    }

    @RequestMapping("/employee/insert")
    public Employee insert(@RequestParam  String name, String position, int brigadeId)
    {
        Brigade brigade = new Brigade(null,null, null, null);
        brigade.setId(brigadeId);
        Employee employee = new Employee(name, position, brigade);
        return service.insert(employee);

    }

    @RequestMapping("/employee/update")
    public Employee update(@RequestParam int id, String name, String position, int brigadeId)
    {
        Brigade brigade = new Brigade(null,null, null, null);
        brigade.setId(brigadeId);
        Employee employee = new Employee(name, position, brigade);
        employee.setId(id);
        return service.update(employee);

    }
}
