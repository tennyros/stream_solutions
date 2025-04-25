package com.github.tennyros.solutions.stream_api.grouping.count_above_avg_salaries_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Количество сотрудников с зарплатой выше средней по департаменту <br><br>
 * Условие: <br>
 * У тебя есть список сотрудников List<Employee> с полями: <br>
 * - String name <br>
 * - String department <br>
 * - int salary <br><br>
 * Нужно вернуть Map<String, Long>, где: <br>
 * - ключ — название департамента, <br>
 * - значение — количество сотрудников, чья зарплата выше средней по их департаменту.
 * */
public class CountAboveAvgSalariesByDep {

    public static void main(String[] args) {
        System.out.println(countAboveAverageSalariesByDepartment(List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700)
        )));
    }

    public static Map<String, Long> countAboveAverageSalariesByDepartment(List<Employee> employees) {

        Map<String, Double> filter = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.filtering(
                                e -> e.getSalary() > filter.get(e.getDepartment()),
                                Collectors.counting()
                        )
                ));
    }

}
