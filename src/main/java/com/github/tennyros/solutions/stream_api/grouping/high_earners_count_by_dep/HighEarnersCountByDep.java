package com.github.tennyros.solutions.stream_api.grouping.high_earners_count_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class HighEarnersCountByDep {

    private HighEarnersCountByDep() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Подсчёт количества сотрудников с зарплатой выше 10 000 по каждому департаменту <p>
     * Метод возвращает карту, где: <p>
     * - ключ — название департамента, <p>
     * - значение — количество сотрудников в этом департаменте, у которых зарплата больше 10000.
     *
     * @param employees список сотрудников
     * @return карта вида Map<департамент, количество сотрудников в департаменте>
     */
    public static Map<String, Long> highEarnersCountByDepartment(List<Employee> employees) {

        return employees.stream()
                .filter(emp -> emp.getSalary() > 10_000)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }

}
