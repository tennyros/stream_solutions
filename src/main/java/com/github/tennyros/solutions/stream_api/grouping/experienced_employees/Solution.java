package com.github.tennyros.solutions.stream_api.grouping.experienced_employees;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <b>Самые опытные сотрудники в каждом департаменте</b>
 * <br></br>
 * Нужно реализовать метод:
 * <br>
 * public static Map<String, List<String>> topExperiencedEmployeesByDepartment(List<Employee> employees, int topN)
 * <br>
 * 🔹 Метод должен вернуть Map<департамент, список имён сотрудников>, где список содержит top N самых опытных сотрудников из каждого департамента.
 * <br>
 * 🔹 Если в департаменте меньше N человек — вернуть всех.
 * <br>
 * 🔹 Сортировка — по убыванию стажа.
 */
public class Solution {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 4, 105004),
                new Employee("Jane", "IT", 6, 92506),
                new Employee("Jessy", "IT", 3, 8700),
                new Employee("Base", "HR", 5, 7700),
                new Employee("Home", "HR", 2, 10700),
                new Employee("Smith", "Sales", 8, 11000),
                new Employee("Sam", "Sales", 2, 9000),
                new Employee("Sara", "Sales", 6, 13000)
        );

        System.out.println(topExperiencedEmployeesByDepartment(employees, 2));
    }

    public static Map<String, List<String>> topExperiencedEmployeesByDepartment(List<Employee> employees, int topN) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Employee::getYearsOfExperience).reversed())
                                        .limit(topN)
                                        .map(Employee::getName)
                                        .collect(Collectors.toList())
                        )
                ));
    }

}
