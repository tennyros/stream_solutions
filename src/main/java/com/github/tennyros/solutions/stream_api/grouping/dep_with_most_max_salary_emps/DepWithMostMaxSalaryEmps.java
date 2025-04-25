package com.github.tennyros.solutions.stream_api.grouping.dep_with_most_max_salary_emps;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DepWithMostMaxSalaryEmps {

    private DepWithMostMaxSalaryEmps() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Возвращает департамент с наибольшим числом сотрудников, получающих максимальную зарплату. <p>
     * Если таких департаментов несколько, выбирается тот, где максимальная зарплата была достигнута первым. <p>
     *
     * @param employees список сотрудников
     * @return название департамента
     */
    public static String departmentWithMostMaxSalaryEmployees(List<Employee> employees) {

        Integer maxSalary = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary)
                .orElse(0);

        return employees.stream()
                .filter(e -> e.getSalary() == maxSalary)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                )).entrySet().stream()
                .max(Map.Entry.<String, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }

}
