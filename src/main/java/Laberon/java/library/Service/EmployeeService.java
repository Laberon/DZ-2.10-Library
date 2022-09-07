package Laberon.java.library.Service;

import Laberon.java.library.Domain.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee addPerson(String firstName, String lastName, int salary, int department);



    List<Employee> findPersons(String firstName, String lastName);

    Employee removePerson(String firstName, String lastName, int salary, int department);

    Collection<Employee> getAll();

    List<Employee> getEmployeeDepartment(Integer department);
}
