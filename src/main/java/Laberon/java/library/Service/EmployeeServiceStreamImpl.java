package Laberon.java.library.Service;

import Laberon.java.library.Domain.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import static Laberon.java.library.Service.EmployeeServiceImpl.employeeMap;

@Service
public class EmployeeServiceStreamImpl implements EmployeeServiceStream {

    private EmployeeServiceImpl employeeService;

    public EmployeeServiceStreamImpl(EmployeeServiceImpl employeeService) {
        this.employeeService=employeeService;
    }


    @Override
    public String getSalaryMin(Integer department) {
        int salary=0;
//        int department = 0;
        String firstName = null;
        String lastName=null;
        Employee employee = new Employee(firstName, lastName,salary,department);
        String.valueOf(employeeMap.values().stream()
                .filter(employees -> employee.getDepartment().contains(department)));
//                .min(Comparator.comparing(employees -> employee.getSalary())));
//                .get();
//                .collect(Collectors.toList()));
                return Comparator.comparingInt(employees -> employee.getSalary()).toString();
//        return "null";
    }

//    @Override
//    public List<Employee> getSalaryMin(Integer department) {
//        final Employee employee = (Employee) employeeMap.values();
//        final List<Employee> employeesByDepartment = getDepartment(department);
//        final List<Employee> departments = employeesByDepartment.stream()
//                .filter(e -> e.getDepartment().contains(department))
//                .collect(Collectors.toList());
//        Comparator.comparingInt(employee1 -> employee.getSalary());
//        return null;
//    }

}
