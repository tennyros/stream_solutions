package com.github.tennyros.solutions.stream_api.grouping.emps_above_avg_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.stream.Collectors;

public final class EmpsAboveAvgSalary {

    private EmpsAboveAvgSalary() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Находит имена сотрудников с зарплатой выше средней по всем сотрудникам.
     *
     * @param employees список сотрудников
     * @return список имён сотрудников с зарплатой выше средней
     */
    public static List<String> employeesAboveAverageSalary(List<Employee> employees) {

        double averageSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0.0);

        return employees.stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

}
