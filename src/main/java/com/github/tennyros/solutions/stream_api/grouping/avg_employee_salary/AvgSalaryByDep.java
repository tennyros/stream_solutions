package com.github.tennyros.solutions.stream_api.grouping.avg_employee_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Посчитать среднюю зарплату по департаментам. <br><br>
 * public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) <br><br>
 * Условие: <br>
 * Необходимо посчитать среднюю зарплату для каждого департамента.
 * Используйте стримы для подсчета средней зарплаты по каждому департаменту.
 */
public class AvgSalaryByDep {

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ));
    }

}
