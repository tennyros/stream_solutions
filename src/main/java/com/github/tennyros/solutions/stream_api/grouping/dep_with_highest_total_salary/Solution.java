package com.github.tennyros.solutions.stream_api.grouping.dep_with_highest_total_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Определить департамент с наибольшей суммарной зарплатой <br><br>
 * Нужно вернуть название департамента, в котором суммарная
 * зарплата всех сотрудников максимальна <br><br>
 * 📥 Вход: <br>
 * Список объектов Employee с полями: <br>
 * - name (String) <br>
 * - department (String) <br>
 * - salary (int) <br><br>
 * 📤 Выход: <br>
 * String: название департамента с наибольшей суммой зарплат
 * */
public class Solution {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10_000),
                new Employee("Bob", "IT", 11_000),
                new Employee("Charlie", "HR", 9_000),
                new Employee("Diana", "HR", 8_500),
                new Employee("Eve", "Sales", 15_000)
        );

        System.out.println(getDepartmentWithHighestTotalSalary(employees));
    }

    public static String getDepartmentWithHighestTotalSalary(List<Employee> employees) {

        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)
                )));
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

}
