package com.github.tennyros.solutions.stream_api.grouping.dep_with_lowest_total_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Написать метод, который найдёт департамент, в
 * котором сумма зарплат сотрудников наименьшая. <br><br>
 * Требования: <br>
 * На вход — List<Employee> employees. <br>
 * Вернуть — String (название департамента с наименьшей суммой зарплат). <br>
 * Если сотрудников нет — вернуть пустую строку. <br>
 * public static String departmentWithLowestTotalSalary(List<Employee> employees)
 */
public class DepWithLowestTotalSalary {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Alice", "IT", 29, 12000),
                new Employee("Charlie", "HR", 30, 9000),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Diana", "HR", 28, 9900),
                new Employee("Eve", "Sales", 29, 10500),
                new Employee("Eve", "Sales", 31, 11000)
        );

        System.out.println(departmentWithLowestTotalSalary(employees));
    }

    public static String departmentWithLowestTotalSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.summarizingInt(Employee::getSalary),
                                IntSummaryStatistics::getSum
                        )
                ))
                .entrySet().stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }

}
