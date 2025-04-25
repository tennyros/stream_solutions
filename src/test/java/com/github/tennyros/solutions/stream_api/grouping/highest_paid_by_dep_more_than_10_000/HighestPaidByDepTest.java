package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep_more_than_10_000;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static List<Employee> employees;

    @BeforeEach
    void initEmployees() {
        employees = List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700),
                new Employee("Smith", "Sales", 11_000),
                new Employee("Sam", "Sales", 9_000),
                new Employee("Sara", "Sales", 13_000)
        );
    }

    @Test
    void testHighestPaidByDepartment() {
        Map<String, String> highestPaidByDep = Solution.highestPaidByDepartment(employees);

        assertAll(
                () -> assertEquals("Sara", highestPaidByDep.get("Sales")),
                () -> assertEquals("Home", highestPaidByDep.get("HR")),
                () -> assertEquals("John", highestPaidByDep.get("IT"))
        );

        Map<String, String> expected = Map.of(
                "Sales", "Sara",
                "HR", "Home",
                "IT", "John"
        );
        assertEquals(expected, highestPaidByDep);

    }

}