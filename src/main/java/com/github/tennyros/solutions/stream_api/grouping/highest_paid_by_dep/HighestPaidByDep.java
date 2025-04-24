package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Найти самого высокооплачиваемого сотрудника в каждом департаменте.
 * <br>
 * 📥 Вход:
 * <br>
 * Список List<Employee>, где у Employee есть:
 * <br>
 * - String name;
 * <br>
 * - String department;
 * <br>
 * - int salary;
 * <br>
 * 📤 Выход:
 * <br>
 * Map<String, String> — где ключом является департамент, а значением — имя сотрудника с самой высокой зарплатой в этом департаменте.
 */
public class HighestPaidByDep {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 9000),
                new Employee("Jane", "IT", 12000),
                new Employee("Bill", "HR", 11000),
                new Employee("Anna", "HR", 12500)
        );

        System.out.println(highestPaidByDepartment(employees));
    }

    public static Map<String, String> highestPaidByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                e -> e.map(Employee::getName).orElse("")
                        )
                ));
    }

}
