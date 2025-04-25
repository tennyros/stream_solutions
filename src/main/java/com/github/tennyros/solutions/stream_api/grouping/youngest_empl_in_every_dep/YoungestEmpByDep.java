package com.github.tennyros.solutions.stream_api.grouping.youngest_empl_in_every_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public final class YoungestEmpByDep {

    private YoungestEmpByDep() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Самый молодой сотрудник в каждом департаменте <p>
     * Метод возвращает карту, где: <p>
     * - ключ — название департамента, <p>
     * - значение — имя самого молодого сотрудника в этом департаменте.
     *
     * @param employees список сотрудников
     * @return карта вида Map<департамент, имя самого молодого сотрудника>
     * */
    public static Map<String, String> youngestEmployeeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Employee::getAge)),
                                optEmp -> optEmp.map(Employee::getName).orElse("N/A")
                        )
                ));
    }

}
