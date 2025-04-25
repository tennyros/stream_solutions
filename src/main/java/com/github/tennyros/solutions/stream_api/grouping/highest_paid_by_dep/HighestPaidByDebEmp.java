package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Напишите метод highestPaidEmployeeInEachDepartment,
 * который для каждого департамента возвращает сотрудника с наибольшей зарплатой. <br><br>
 * Метод должен принимать список сотрудников и возвращать Map<String, Employee>,
 * где ключом будет название департамента, а значением — объект
 * сотрудника с наибольшей зарплатой в этом департаменте.
 * */
public class HighestPaidByDebEmp {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Charlie", "HR", 30, 9000),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Eve", "Sales", 29, 10500)
        );

        System.out.println(highestPaidEmployeeInEachDepartment(employees));
    }

    public static Map<String, Employee> highestPaidEmployeeInEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                Optional::get
                        )
                ));
    }

    public static Map<String, Employee> highestPaidEmployeeInEachDepartmentWithToMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary))));
    }

}
