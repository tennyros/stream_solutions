package com.github.tennyros.solutions.stream_api.grouping.max_salary_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.github.tennyros.solutions.stream_api.grouping.max_salary_by_dep.MaxSalaryByDep.maxSalaryByDepartment;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSalaryByDepTest {

    @Test
    void shouldReturnMaxSalaryForEachDepartment() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "IT", 12000),
                new Employee("Charlie", "HR", 9000)
        );

        Map<String, Integer> result = maxSalaryByDepartment(employees);

        assertEquals(12000, result.get("IT"));
        assertEquals(9000, result.get("HR"));
    }

}