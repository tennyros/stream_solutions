package com.github.tennyros.solutions.stream_api.grouping.above_median_salary_by_department;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class AboveMedianSalaryByDep {

    private AboveMedianSalaryByDep() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Сотрудники, чья зарплата выше медианной по их отделу <p>
     * Для каждого департамента определяет список сотрудников, чьи зарплаты
     * строго выше медианной зарплаты по их отделу. <p>
     * Пример: Если в департаменте "IT" зарплаты: 8000, 10000, 12000 — медиана
     * будет 10000. В результат попадут только те, у кого зарплата > 10000.
     *
     * @param employees список сотрудников
     * @return карта вида Map<департамент, список сотрудников>
     */
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
