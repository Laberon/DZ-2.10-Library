package Laberon.java.library.Service;

import Laberon.java.library.Domain.Employee;
import Laberon.java.library.Exception.EmployeeAlreadyAddedException;
import Laberon.java.library.Exception.EmployeeNotFoundException;
import Laberon.java.library.Exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    static final Map<String, Employee> employeeMap = new HashMap<>(Map.of(
//            "РАБОТИН", new Employee("РАБОТИН", "Агафон", 1_000, 1),
//           "НАБИЕВА", new Employee("НАБИЕВА", "Беатрис Бенедиктович", 2000,2),
//            "ДАНИЛЕЙКО", new Employee("ДАНИЛЕЙКО", "Вальтер Вадимович", 3000,3),
//            "ХАВИН",new Employee("ХАВИН", "Дамир Венедиктович", 3000,3),
//            "ШАБАШЕВ", new Employee("ШАБАШЕВ", "Егор Виссарионович", 4000,2),
//            "ЗАДОРИНа",new Employee("ЗАДОРИНа", "Зарина Вячеславович", 5000,1)
    ));


    @Override
    public Employee addPerson(String firstName, String lastName, int salary, int department) {
//        if (!validateInput(firstName, lastName)) { первый вариант
//            throw new InvalidInputException();
//        }
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Message");
        }
        employeeMap.values().stream()
                .filter(s-> isBlank((CharSequence) s))
                .filter(e-> Boolean.parseBoolean(capitalize(String.valueOf(e))));
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public List<Employee> findPersons(String firstName, String lastName) {
//        if (!validateInput(firstName, lastName)) { первый вариант
//            throw new InvalidInputException();
//        }
        validateInput(firstName,lastName);
        int salary = 0;
        int department = 0;
        Employee employees = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employees.getFullName())) {
            return Collections.singletonList(employeeMap.get(employees.getFullName()));
        }
        throw new EmployeeNotFoundException("Not found");
    }

    @Override
    public Employee removePerson(String firstName, String lastName, int salary, int department) {
//        if (!validateInput(firstName, lastName)) { первый вариант
//            throw new InvalidInputException();
//        }
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);//,middleName
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Message");
    }

    @Override
    public Collection<Employee> getAll() {
        return employeeMap.values();
    }

    @Override
    public List<Employee> getEmployeeDepartment(Integer department) {
        return employeeMap.values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    private void validateInput(String firstName, String lastName) {
//        return isAlpha(firstName) && isAlpha(lastName); первый вариант
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}