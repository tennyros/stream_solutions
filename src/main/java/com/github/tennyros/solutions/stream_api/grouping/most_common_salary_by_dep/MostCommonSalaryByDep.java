package com.github.tennyros.solutions.stream_api.grouping.most_common_salary_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Самая часто встречающаяся зарплата в каждом отделе
 * <br><br>
 * public static Map<String, Integer> mostCommonSalaryByDepartment(List<Employee> employees)
 * <br>
 * 📍 Где:
 * <br>
 * - String — название отдела
 * <br>
 * - Integer — наиболее часто встречающаяся зарплата в этом отделе
 * <br>
 * (если несколько — бери наименьшую из них)
 */
public class MostCommonSalaryByDep {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Charlie", "IT", 30, 10000),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Eve", "HR", 29, 9500),
                new Employee("Frank", "HR", 35, 9000)
        );

        System.out.println(mostCommonSalaryByDepartment(employees));
    }

    public static Map<String, Integer> mostCommonSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        Employee::getSalary,
                                        Collectors.counting()
                                ),
                                salaryCountMap -> salaryCountMap.entrySet().stream()
                                        .max(Map.Entry.<Integer, Long>comparingByValue()
                                                .thenComparing(Map.Entry.comparingByKey()))
                                        .map(Map.Entry::getKey)
                                        .orElse(null)
                        )
                ));
    }

}
