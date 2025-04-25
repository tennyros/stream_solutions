package com.github.tennyros.solutions.stream_api.grouping.dep_with_oldest_emp;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * departmentWithOldestEmployee <br><br>
 * Необходимо написать метод, который находит департамент,
 * в котором работает сотрудник с самым высоким возрастом. <br>
 * Если несколько департаментов содержат сотрудников с одинаковым максимальным возрастом,
 * нужно вернуть департамент с наибольшим количеством сотрудников. <br><br>
 * Параметры: <br>
 * Метод принимает список сотрудников, каждый из которых является объектом класса Employee. <br>
 * У каждого сотрудника есть следующие атрибуты: <br>
 * - name (имя сотрудника, строка) <br>
 * - department (департамент, строка) <br>
 * - age (возраст сотрудника, целое число) <br>
 * - salary (зарплата, целое число) <br><br>
 * Возвращаемое значение: <br>
 * Метод должен возвращать название департамента, в котором работает самый старший сотрудник. <br>
 * Если несколько департаментов имеют одинаковый максимальный
 * возраст, вернуть департамент с наибольшим количеством сотрудников.
 */
public class DepWithOldestEmpl {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 30, 10000),
                new Employee("Bob", "IT", 40, 12000),
                new Employee("Charlie", "HR", 35, 9000),
                new Employee("Diana", "HR", 40, 9500),
                new Employee("Eve", "Sales", 45, 11000),
                new Employee("Frank", "Sales", 45, 11500)
        );

        String department = departmentWithOldestEmployee(employees);
        System.out.println(department); // "Sales"
    }

    public static String departmentWithOldestEmployee(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getAge)),
                                optional -> optional.orElse(null)
                        )
                )).entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().getAge()))
                .map(Map.Entry::getKey).orElse("");
    }

}
