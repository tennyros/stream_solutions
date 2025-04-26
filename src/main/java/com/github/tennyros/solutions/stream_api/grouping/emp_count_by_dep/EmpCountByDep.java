package com.github.tennyros.solutions.stream_api.grouping.emp_count_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Количество сотрудников по каждому департаменту <br><br>
 * public static Map<String, Long> employeeCountByDepartment(List<Employee> employees) <br><br>
 * Условие:<br>
 * Посчитайте количество сотрудников в каждом департаменте. Верните Map, где
 * ключ — это название департамента, а значение — количество сотрудников в нём.
 */
public class EmpCountByDep {

    public static Map<String, Long> employeeCountByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }

}
