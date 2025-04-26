package com.github.tennyros.solutions.stream_api.grouping.high_earners_count_by_dep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class BenchmarkTest {

    static class Employee {
        private final String name;
        private final int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = generateEmployees(10_000_000);

        long start1 = System.nanoTime();
        Map<Character, Integer> result1 = maxSalaryFirstVersion(employees);
        long duration1 = System.nanoTime() - start1;
        System.out.println("First version duration: " + duration1 / 10_000_000 + " ms");

        long start2 = System.nanoTime();
        Map<Character, Integer> result2 = maxSalarySecondVersion(employees);
        long duration2 = System.nanoTime() - start2;
        System.out.println("Second version duration: " + duration2 / 10_000_000 + " ms");
    }

    private static List<Employee> generateEmployees(int count) {
        Random random = new Random();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            char firstLetter = (char) ('A' + random.nextInt(26));
            list.add(new Employee(firstLetter + "_Employee_" + i, random.nextInt(100_000)));
        }
        return list;
    }

    public static Map<Character, Integer> maxSalaryFirstVersion(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getName().charAt(0),
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                opt -> opt.map(Employee::getSalary).orElse(0)
                        )
                ));
    }

    public static Map<Character, Integer> maxSalarySecondVersion(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getName().charAt(0),
                        Collectors.collectingAndThen(
                                Collectors.mapping(
                                        Employee::getSalary,
                                        Collectors.maxBy(Comparator.naturalOrder())
                                ),
                                opt -> opt.orElse(0)
                        )
                ));
    }
}
