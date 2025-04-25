package com.github.tennyros.solutions.stream_api.grouping.dep_with_lowest_avg_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Найти департамент с наименьшей средней зарплатой среди всех сотрудников компании. <br><br>
 * public static String departmentWithLowestAverageSalary(List<Employee> employees); <br><br>
 * Условие задачи: <br>
 * Вы должны найти департамент, у которого самая низкая средняя зарплата. <br>
 * В случае, если таких департаментов несколько, выберите
 * департамент с наименьшим названием (в алфавитном порядке). <br>
 * Если список сотрудников пустой, метод должен возвращать пустую строку.
 */
public class DepWithLowestAvgSalary {

    public static String departmentWithLowestAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                )).entrySet().stream()
                .min(Map.Entry.<String, Double>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

}
