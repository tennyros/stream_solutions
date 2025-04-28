package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HighestEarnerByDepTest {

    @Test
    void shouldReturnHighestEarnerByDep() {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 9000),
                new Employee("Bob", "HR", 12000),
                new Employee("Charlie", "Engineering", 15000),
                new Employee("David", "Engineering", 13000),
                new Employee("Eve", "Finance", 11000),
                new Employee("Frank", "Finance", 11000)
        );

        Map<String, String> result = HighestEarnerByDep.highestEarnerByDepartment(employees);

        assertAll(
                () -> assertEquals("Bob", result.get("HR")),
                () -> assertEquals("Charlie", result.get("Engineering")),
                () -> assertEquals("Eve", result.get("Finance"))
        );

    }

}