package com.github.tennyros.solutions.stream_api.grouping.most_common_name_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Самое популярное имя в каждом отделе <br><br>
 * У тебя есть список сотрудников. У каждого есть: <br>
 * - String name <br>
 * - String department <br>
 * - int age <br>
 * - int salary <br><br>
 * Твоя задача — реализовать метод: <br>
 * public static Map<String, String> mostCommonNameByDepartment(List<Employee> employees) <br>
 * 🔹 Где ключ — это название отдела, <br>
 * 🔹 Значение — самое часто встречающееся имя в этом отделе. <br>
 * 🔹 При равенстве количества — взять лексикографически наименьшее имя.
 * */
public class MostCommonNameByDep {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Alice", "IT", 29, 12000),
                new Employee("Charlie", "HR", 30, 9000),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Diana", "HR", 28, 9900),
                new Employee("Eve", "Sales", 29, 10500),
                new Employee("Eve", "Sales", 31, 11000)
        );

        System.out.println(mostCommonNameByDepartment(employees));
    }

    public static Map<String, String> mostCommonNameByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        Employee::getName,
                                        Collectors.counting()
                                ),
                                namesCountMap -> namesCountMap.entrySet().stream()
                                        .max(Map.Entry.<String, Long>comparingByValue()
                                                .thenComparing(Map.Entry.comparingByKey()))
                                        .map(Map.Entry::getKey)
                                        .orElse(null)
                        )
                ));
    }

}
