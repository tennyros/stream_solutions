package com.github.tennyros.solutions.stream_api.grouping.avg_salary_of_top_exp_emps;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Средняя зарплата среди самых опытных сотрудников по отделам <br>
 * public static double averageSalaryOfTopExperiencedEmployees(List<Employee> employees, int topN) <br><br>
 * Что должен делать метод: <br>
 * 1) Для каждого отдела (department) выбрать topN самых опытных сотрудников (experience). <br>
 * 2) Посчитать среднюю зарплату по этим topN сотрудникам в каждом отделе. <br>
 * 3) Вернуть общую среднюю зарплату по всем topN-сотрудникам всех отделов.
 * */
public class Solution {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000, 4, 28),
                new Employee("Bob", "IT", 11000, 3, 24),
                new Employee("Charlie", "HR", 9000, 5, 30),
                new Employee("Diana", "HR", 9500, 5, 25),
                new Employee("Eve", "Sales", 10500, 3, 29)
        );

        System.out.println(averageSalaryOfTopExperiencedEmployees(employees, 2));
    }

    public static double averageSalaryOfTopExperiencedEmployees(List<Employee> employees, int topN) {

        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values());

        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values().stream() // получаем коллекции сотрудников по департаментам
                .flatMap(departmentList -> departmentList.stream()
                        .sorted(Comparator.comparingInt(Employee::getYearsOfExperience).reversed())
                        .limit(topN)));

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values().stream() // получаем коллекции сотрудников по департаментам
                .flatMap(departmentList -> departmentList.stream()
                        .sorted(Comparator.comparingInt(Employee::getYearsOfExperience).reversed())
                        .limit(topN))
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

}
