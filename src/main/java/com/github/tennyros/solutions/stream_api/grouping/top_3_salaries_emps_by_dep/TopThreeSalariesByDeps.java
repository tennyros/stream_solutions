package com.github.tennyros.solutions.stream_api.grouping.top_3_salaries_emps_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Список сотрудников, у которых зарплата входит в топ-3 в каждом департаменте <br><br>
 * Условие: <br>
 * У тебя есть список List<Employee> employees, у каждого Employee есть: <br>
 * - имя (getName()), <br>
 * - департамент (getDepartment()), <br>
 * - зарплата (getSalary()). <br><br>
 * Нужно: <br>
 * Вернуть Map<String, List<String>>, где: <br>
 * - ключ — это название департамента, <br>
 * - значение — список имён сотрудников с топ-3 зарплатами в этом департаменте. <br><br>
 * Пример: <br>
 * Если в департаменте "IT" есть 5 сотрудников, то в значение попадут только 3 с наибольшими зарплатами (или меньше, если людей меньше).
 * */
public class TopThreeSalariesByDeps {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Charlie", "IT", 32, 9500),
                new Employee("David", "IT", 30, 11500),
                new Employee("Eve", "HR", 29, 10500),
                new Employee("Faythe", "HR", 31, 8700),
                new Employee("Grace", "HR", 27, 9400),
                new Employee("Heidi", "HR", 35, 9100),
                new Employee("Ivan", "Sales", 26, 12000),
                new Employee("Judy", "Sales", 28, 11800),
                new Employee("Karl", "Sales", 30, 10200),
                new Employee("Leo", "Sales", 33, 9800),
                new Employee("Mallory", "Finance", 29, 12500),
                new Employee("Niaj", "Finance", 31, 12200),
                new Employee("Olivia", "Finance", 34, 11700),
                new Employee("Peggy", "Finance", 28, 11900),
                new Employee("Quentin", "Marketing", 26, 8800),
                new Employee("Rupert", "Marketing", 27, 9000),
                new Employee("Sybil", "Marketing", 30, 9200),
                new Employee("Trent", "Marketing", 32, 8700)
        );

        System.out.println(topThreeSalariesByDepartment(employees));
    }

    public static Map<String, List<String>> topThreeSalariesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Employee::getSalary))
                                        .limit(3)
                                        .map(Employee::getName)
                                        .collect(Collectors.toList())

                        )
                ));
    }

}
