package com.github.tennyros.solutions.stream_api.grouping.emp_count_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmpCountByDepTest {

    @Test
    void shouldReturnEmployeeCountByDepartment() {

        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "HR", 11000),
                new Employee("Charlie", "IT", 12000)
        );

        Map<String, Long> result = EmpCountByDep.employeeCountByDepartment(employees);

        assertEquals(2, result.get("IT"));
        assertEquals(1, result.get("HR"));

    }

}