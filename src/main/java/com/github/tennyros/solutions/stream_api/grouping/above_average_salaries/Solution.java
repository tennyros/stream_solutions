package com.github.tennyros.solutions.stream_api.grouping.above_average_salaries;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Найти имена всех сотрудников, чья зарплата превышает среднюю по их департаменту.
 * <br><br>
 * Метод должен вернуть List<String> — список имен сотрудников, чья зарплата выше средней в их департаменте.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(aboveAverageSalaries(List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700)
        )));
    }

    public static List<String> aboveAverageSalaries(List<Employee> employees) {
        Map<String, Double> avgSalaries = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
        return employees.stream()
                .filter(e -> e.getSalary() > avgSalaries.get(e.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

}
