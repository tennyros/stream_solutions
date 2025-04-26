package com.github.tennyros.solutions.stream_api.grouping.top_salary_more_than_n;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Найти департаменты, в которых есть хотя бы один сотрудник с зарплатой выше N. <br>
 * Требуется: Вернуть List<String> — названия департаментов, в которых есть хотя бы один сотрудник с зарплатой выше заданного threshold.
 */
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

        System.out.println(departmentsWithTopSalaries(employees, 10_000));
    }

    public static List<String> departmentsWithTopSalaries(List<Employee> employees, int threshold) {
        return employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

}
