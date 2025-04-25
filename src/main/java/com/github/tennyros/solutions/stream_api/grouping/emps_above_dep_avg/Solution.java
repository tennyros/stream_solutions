package com.github.tennyros.solutions.stream_api.grouping.emps_above_dep_avg;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Нужно получить имена сотрудников, чья зарплата выше средней зарплаты по их отделу. <br><br>
 * Реализовать метод: <br>
 * public static List<String> employeesAboveDepartmentAverage(List<Employee> employees) <br>
 * Который вернёт список имён, например: <br>
 * ["John", "Home", "Smith", "Sara"]
 * */
public class Solution {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700),
                new Employee("Smith", "Sales", 11_000),
                new Employee("Sam", "Sales", 9_000),
                new Employee("Sara", "Sales", 13_000)
        );

        System.out.println(employeesAboveDepartmentAverage(employees));
    }

    public static List<String> employeesAboveDepartmentAverage(List<Employee> employees) {
        Map<String, Double> avbSalaryByDep = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
        return employees.stream()
                .filter(e -> e.getSalary() > avbSalaryByDep.get(e.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

}
