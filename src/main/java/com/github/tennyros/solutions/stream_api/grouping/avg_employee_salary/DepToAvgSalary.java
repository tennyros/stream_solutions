package com.github.tennyros.solutions.stream_api.grouping.avg_employee_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Группировка сотрудников по отделу <br>
 * У тебя есть список сотрудников List<Employee>. <br>
 * Группируй сотрудников по отделу (department) и посчитай среднюю зарплату в каждом отделе.
 */
public class DepToAvgSalary {

    public static Map<String, Double> departmentToAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
    }

}
