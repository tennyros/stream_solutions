package com.github.tennyros.solutions.stream_api.grouping.above_average_salaries;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class AboveAvgSalaries {

    private AboveAvgSalaries() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Метод возвращает список имен сотрудников, чья зарплата выше средней в их департаменте.
     *
     * @param employees список сотрудников
     * @return список сотрудников
     */
    public static List<String> aboveAverageSalaries(List<Employee> employees) {
        Map<String, Double> avgSalaries = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
        return employees.stream()
                .filter(e -> e.getSalary() >= avgSalaries.get(e.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

}
