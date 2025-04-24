package com.github.tennyros.solutions.stream_api.grouping.dep_with_most_emps;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Найти департамент с наибольшим количеством сотрудников.
 * <br><br>
 * ✅ Условия:
 * <br>
 * У тебя есть список сотрудников List<Employee>.
 * <br>
 * Каждый сотрудник имеет департамент (getDepartment()).
 * <br>
 * Нужно определить название департамента, в котором работает больше всего сотрудников.
 * */
public class DepWithMostEmps {

    public static void main(String[] args) {
        System.out.println(departmentWithMostEmployees(List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700)
        )));
    }

    public static String departmentWithMostEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }


}
