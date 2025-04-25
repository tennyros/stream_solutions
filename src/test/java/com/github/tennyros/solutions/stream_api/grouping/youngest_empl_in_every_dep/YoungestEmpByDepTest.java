package com.github.tennyros.solutions.stream_api.grouping.youngest_empl_in_every_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static List<Employee> employees;

    @BeforeEach
    void initData() {
        employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Charlie", "HR", 30, 9000),
                new Employee("Diana", "HR", 25, 9500),
                new Employee("Eve", "Sales", 29, 10500)
        );
    }

    @Test
    void shouldReturnYoungestEmployeeNamePerDepartment() {
        Map<String, String> expected = Map.of(
                "IT", "Bob",
                "HR", "Diana",
                "Sales", "Eve"
        );

        assertEquals(expected, Solution.youngestEmployeeByDepartment(employees));
    }

    @Test
    void shouldReturnEmptyList() {
        assertTrue(Solution.youngestEmployeeByDepartment(List.of()).isEmpty());
    }

}