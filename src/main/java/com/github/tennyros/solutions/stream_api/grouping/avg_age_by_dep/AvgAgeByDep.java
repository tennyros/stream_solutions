package com.github.tennyros.solutions.stream_api.grouping.avg_age_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Средний возраст по отделам <br><br>
 * public static Map<String, Double> averageAgeByDepartment(List<Employee> employees) <br><br>
 * Условие:
 * В компании работают сотрудники, каждый из которых имеет имя, отдел и возраст. <br>
 * Вам нужно сгруппировать сотрудников по отделам и для
 * каждого отдела посчитать средний возраст сотрудников. <br>
 * Метод должен вернуть Map<String, Double>, где ключ — это
 * название отдела, а значение — средний возраст сотрудников этого отдела.
 */
public class AvgAgeByDep {

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

        System.out.println(averageAgeByDepartment(employees));
    }

    public static Map<String, Double> averageAgeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getAge)
                ));
    }

}
