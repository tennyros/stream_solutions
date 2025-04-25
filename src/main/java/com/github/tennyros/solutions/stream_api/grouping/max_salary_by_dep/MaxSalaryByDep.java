package com.github.tennyros.solutions.stream_api.grouping.max_salary_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Максимальная зарплата по отделам <br><br>
 * public static Map<String, Integer> maxSalaryByDepartment(List<Employee> employees) <br><br>
 * Условие: <br>
 * Напишите метод, который находит максимальную зарплату в каждом отделе.
 * То есть для каждого отдела нужно определить максимальное
 * значение поля salary среди всех сотрудников этого отдела.
 * */
public class MaxSalaryByDep {

    private MaxSalaryByDep() {}

    public static Map<String, Integer> maxSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                e -> e.map(Employee::getSalary).orElse(0)
                        )
                ));
    }

}
