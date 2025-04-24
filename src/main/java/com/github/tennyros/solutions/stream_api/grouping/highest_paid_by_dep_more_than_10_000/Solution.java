package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep_more_than_10_000;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Найти топ-1 самого высокооплачиваемого сотрудника в каждом отделе,
 * но только если его зарплата больше 10_000.
 * Вернуть Map<Отдел, Имя сотрудника>.
 */
public class Solution {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700),
                new Employee("Smith", "Sales", 11_000),
                new Employee("Sam", "Sales", 9_000),
                new Employee("Sara", "Sales", 13_000)
        );

        System.out.println(highestPaidByDepartment(employees));
    }

    public static Map<String, String> highestPaidByDepartment(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getSalary() > 10_000)
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                opt -> opt.map(Employee::getName).orElse("Нет подходящего сотрудника")
                        )
                ));
    }

}
