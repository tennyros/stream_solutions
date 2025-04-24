package com.github.tennyros.solutions.stream_api.grouping.youngest_empl_in_every_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class YoungestEmpByDep {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Charlie", "HR", 30, 9000),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Eve", "Sales", 29, 10500)
        );

        System.out.println(youngestEmployeeByDepartment(employees));
    }

    public static Map<String, String> youngestEmployeeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Employee::getAge)),
                                        emp -> emp.map(Employee::getName).orElse("None")
                        )
                ));
    }

    public static Map<String, String> youngestEmployeeByDepartmentFlatMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Employee::getAge)),
                                emp -> emp.flatMap(e -> Optional.ofNullable(e.getName())).orElse("None")
                        )
                ));
    }

}
