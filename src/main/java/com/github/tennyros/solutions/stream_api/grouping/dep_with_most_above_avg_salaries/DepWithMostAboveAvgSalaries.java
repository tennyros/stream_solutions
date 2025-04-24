package com.github.tennyros.solutions.stream_api.grouping.dep_with_most_above_avg_salaries;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Напишите метод, который находит департамент, в котором наибольшее
 * количество сотрудников получает зарплату выше средней по всей компании.
 * <br><br>
 * Условия:
 * <br>
 * У нас есть список сотрудников, каждый из которых имеет:
 * <br>
 * - name (имя сотрудника),
 * <br>
 * - department (департамент),
 * <br>
 * - salary (зарплата сотрудника).
 * <br>
 * Необходимо вычислить среднюю зарплату по всем сотрудникам.
 * <br>
 * Нужно найти департамент, в котором наибольшее количество сотрудников получает зарплату выше средней.
 * <br>
 * Если в нескольких департаментах одинаковое количество сотрудников с зарплатой выше средней, выберите любой департамент.
 * <br>
 * Если таких департаментов нет, метод должен вернуть пустую строку.
 */
public class DepWithMostAboveAvgSalaries {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "IT", 11000),
                new Employee("Charlie", "HR", 9000),
                new Employee("Diana", "HR", 9500),
                new Employee("Eve", "Sales", 10500)
        );

        System.out.println(departmentWithMostAboveAverageSalaries(employees));
    }

    public static String departmentWithMostAboveAverageSalaries(List<Employee> employees) {

        Double averageSalary = employees.stream()
                .collect(Collectors.averagingInt(Employee::getSalary));

        return employees.stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

}
