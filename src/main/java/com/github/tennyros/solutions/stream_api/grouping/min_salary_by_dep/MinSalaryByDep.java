package com.github.tennyros.solutions.stream_api.grouping.min_salary_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Минимальная зарплата по каждому отделу<br><br>
 * public static Map<String, Integer> minSalaryByDepartment(List<Employee> employees) <br><br>
 * Условие: <br>
 * Напишите метод, который возвращает Map, где ключ — название отдела,
 * а значение — минимальная зарплата среди всех сотрудников этого отдела. <br>
 * Если сотрудников нет, метод должен вернуть пустую карту.
 * */
public class MinSalaryByDep {

    public static Map<String, Integer> minSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Employee::getSalary)),
                                optionalEmp -> optionalEmp.map(Employee::getSalary).orElse(0)
                        )
                ));
    }


}
