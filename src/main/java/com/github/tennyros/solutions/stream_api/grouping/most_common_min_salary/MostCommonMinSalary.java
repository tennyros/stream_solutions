package com.github.tennyros.solutions.stream_api.grouping.most_common_min_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Самый распространённый уровень зарплаты во всей компании <br><br>
 * Условие: <br>
 * Найдите наиболее часто встречающуюся (т.е. наиболее распространённую) зарплату
 * среди всех сотрудников компании. Если таких несколько — выберите наименьшую из них.
 */
public class MostCommonMinSalary {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "IT", 11000),
                new Employee("John", "IT", 11000),
                new Employee("Charlie", "HR", 9000),
                new Employee("Charlie", "HR", 9000),
                new Employee("Charlie", "HR", 11000),
                new Employee("Diana", "HR", 10000),
                new Employee("Eve", "Sales", 10000)
        );

        System.out.println(mostCommonMinSalary(employees));
    }

    public static int mostCommonMinSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getSalary,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .min(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .orElse(0);
    }

}
