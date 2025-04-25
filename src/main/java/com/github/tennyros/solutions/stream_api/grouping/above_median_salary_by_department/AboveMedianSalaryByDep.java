package com.github.tennyros.solutions.stream_api.grouping.above_median_salary_by_department;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сотрудники, чья зарплата выше медианной по их отделу <br><br>
 * Условие: <br>
 * Для каждого департамента определить список сотрудников, чьи зарплаты
 * строго выше медианной зарплаты по их отделу. <br><br>
 * Сигнатура метода: <br>
 * public static Map<String, List<String>> aboveMedianSalaryByDepartment(List<Employee> employees) <br><br>
 * Пример: Если в департаменте "IT" зарплаты: 8000, 10000, 12000 — медиана
 * будет 10000. В результат попадут только те, у кого зарплата > 10000.
 */
public class AboveMedianSalaryByDep {

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

        System.out.println(aboveMedianSalaryByDepartment(employees));
    }

    public static Map<String, List<String>> aboveMedianSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    List<Employee> sorted = list.stream()
                                            .sorted(Comparator.comparingInt(Employee::getSalary))
                                            .collect(Collectors.toList());

                                    int size = sorted.size();
                                    double median = (size % 2 == 0)
                                            ? (sorted.get(size / 2 - 1).getSalary() + sorted.get(size / 2).getSalary()) / 2.0
                                            : sorted.get(size / 2).getSalary();

                                    return sorted.stream()
                                            .filter(e -> e.getSalary() > median)
                                            .map(Employee::getName)
                                            .collect(Collectors.toList());
                                }
                        )
                ));
    }


}
