package com.github.tennyros.solutions.stream_api.grouping.most_common_age_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Самый популярный возраст в каждом отделе
 * <br><br>
 * У тебя есть список сотрудников (List<Employee>), и тебе нужно определить:
 * <br><br>
 * Какой возраст встречается чаще всего в каждом отделе.
 * <br><br>
 * Если в отделе несколько возрастов с одинаковой максимальной частотой — выбери любой из них (например, минимальный из них по значению, если хочешь детализировать).
 */
public class MostCommonAgeByDep {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 28, 12000),
                new Employee("Charlie", "IT", 30, 11500),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Eve", "HR", 25, 9800),
                new Employee("Frank", "HR", 30, 10500),
                new Employee("Grace", "Sales", 32, 10800)
        );

        System.out.println(mostCommonAgeByDepartment(employees));
    }

    public static Map<String, Integer> mostCommonAgeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        Employee::getAge,
                                        Collectors.counting()
                                ),
                                ageCountMap -> ageCountMap.entrySet().stream()
                                        .max(Map.Entry.<Integer, Long>comparingByValue()
                                                .thenComparing(Map.Entry.comparingByKey())) // если хочешь минимальный при равенстве
                                        .map(Map.Entry::getKey)
                                        .orElse(null)
                        )
                ));
    }

}
