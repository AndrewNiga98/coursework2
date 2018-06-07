package andrew.coursework.repository;

import andrew.coursework.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("select employee from Employee employee where employee.brigade.object.id=:objectId" )
    List <Employee> selectEmployeeByObject(@Param("objectId") int objectId);
}
