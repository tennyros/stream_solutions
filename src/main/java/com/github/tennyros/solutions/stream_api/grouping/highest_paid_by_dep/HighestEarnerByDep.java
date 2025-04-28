package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class HighestEarnerByDep {

    private HighestEarnerByDep() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Сотрудники с максимальной зарплатой по каждому департаменту <p>
     * Метод, который возвращает карту, где: <p>
     * - ключ — название департамента (String), <p>
     * - значение — имя сотрудника (String) с максимальной зарплатой в этом департаменте.
     *
     * @param employees список сотрудников
     * @return карта вида Map<департамент, имя сотрудника>
     */
    public static Map<String, String> highestEarnerByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                e -> e.map(Employee::getName).orElse("N/A")
                        )
                ));
    }

}
