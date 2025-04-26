package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep_emps;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class HighestPaidEmpsByDep {

    private HighestPaidEmpsByDep() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Самые высокооплачиваемые сотрудники в каждом департаменте <p>
     * Метод возвращает карту, где: <p>
     * - ключ — название департамента, <p>
     * - значение — список имён сотрудников с максимальной зарплатой в этом департаменте. <p>
     * Если в департаменте несколько сотрудников с одинаково максимальной зарплатой — их имена должны быть включены все.
     *
     * @param employees список сотрудников
     * @return карта вида Map<департамент, список сотрудников>
     */
    public static Map<String, List<String>> highestPaidEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    int maxSalary = list.stream()
                                            .mapToInt(Employee::getSalary)
                                            .max()
                                            .orElse(0);
                                    return list.stream()
                                            .filter(e -> e.getSalary() == maxSalary)
                                            .map(Employee::getName)
                                            .collect(Collectors.toList());
                                }
                        )
                ));
    }

    public static Map<String, List<String>> highestPaidEmployeesByDepartmentMoreImperative(List<Employee> employees) {
        Map<String, List<Employee>> employeesByDep = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, List<Employee>> entry : employeesByDep.entrySet()) {

            String department = entry.getKey();
            List<Employee> emps = entry.getValue();

            int maxSalary = emps.stream()
                    .mapToInt(Employee::getSalary)
                    .max()
                    .orElse(0);

            List<String> highestPaid = emps.stream()
                    .filter(e -> e.getSalary() == maxSalary)
                    .map(Employee::getName)
                    .collect(Collectors.toList());

            result.put(department, highestPaid);
        }

        return result;
    }

    public static Map<String, List<String>> highestPaidEmployeesByDepartmentImperative(List<Employee> employees) {
        Map<String, List<Employee>> byDep = new HashMap<>();
        for (Employee e : employees) {
            byDep.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
        }

        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, List<Employee>> entry : byDep.entrySet()) {
            int maxSalary = 0;
            for (Employee e : entry.getValue()) {
                if (e.getSalary() > maxSalary) {
                    maxSalary = e.getSalary();
                }
            }

            List<String> names = new ArrayList<>();
            for (Employee e : entry.getValue()) {
                if (e.getSalary() == maxSalary) {
                    names.add(e.getName());
                }
            }

            result.put(entry.getKey(), names);

        }

        return result;
    }

}
