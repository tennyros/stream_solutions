package com.github.tennyros.solutions.stream_api.grouping.max_age_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Максимальный возраст по отделам <br><br>
 * public static Map<String, Integer> maxAgeByDepartment(List<Employee> employees) <br><br>
 * Условие: <br>
 * Найдите самого пожилого сотрудника в каждом отделе. <br>
 * Верните Map, где ключ — название отдела, а значение — максимальный возраст сотрудника в этом отделе.
 * */
public class MaxAgeByDep {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 28, 12000),
                new Employee("Charlie", "IT", 30, 11500),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Eve", "HR", 25, 9800),
                new Employee("Frank", "HR", 30, 10500),
                new Employee("Grace", "Sales", 32, 10800)
        );

        System.out.println(maxAgeByDepartment(employees));
    }

    public static Map<String, Integer> maxAgeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getAge)),
                                e -> e.map(Employee::getAge).orElse(0)
                        )
                ));
    }

}
