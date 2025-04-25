package com.github.tennyros.solutions.stream_api.grouping.min_salary_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinSalaryByDepTest {

    @Test
    void shouldReturnMinSalaryByDep() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "IT", 12000),
                new Employee("Charlie", "HR", 9000),
                new Employee("Hugh", "HR", 8000)
        );

        Map<String, Integer> result = MinSalaryByDep.minSalaryByDepartment(employees);

        assertEquals(10000, result.get("IT"));
        assertEquals(8000, result.get("HR"));
    }

}