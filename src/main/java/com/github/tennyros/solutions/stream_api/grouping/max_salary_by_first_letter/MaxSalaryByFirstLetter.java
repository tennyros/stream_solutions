package com.github.tennyros.solutions.stream_api.grouping.max_salary_by_first_letter;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class MaxSalaryByFirstLetter {

    private MaxSalaryByFirstLetter() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Максимальная зарплата по первой букве имени сотрудника <p>
     * Метод возвращает карту, где: <p>
     * - ключ — первая буква имени сотрудника (Character), <p>
     * - значение — максимальная зарплата среди сотрудников, чьё имя начинается на эту букву. <p>
     * Игнорировать регистр букв (например, alex и Anna считаются одной буквой A). <p>
     * Если буква встречается несколько раз — брать наибольшую зарплату для этой буквы.
     *
     * @param employees список сотрудников
     * @return карта вида Map<первая буква имени, максимальная зарплата сотрудников>
     */
    public static Map<Character, Integer> maxSalaryByFirstLetter(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getName().charAt(0),
                        Collectors.collectingAndThen(
                                Collectors.mapping(
                                        Employee::getSalary,
                                        Collectors.maxBy(Comparator.naturalOrder()
                                        )),
                                opt -> opt.orElse(0)
                        ))
                );
    }

}
