package com.github.tennyros.solutions.stream_api.grouping.high_earners_count_by_dep;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighEarnersCountByDepTest {

    @Test
    void shouldReturnHighEarnersCountByDep() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 12000),
                new Employee("Bob", "IT", 9500),
                new Employee("Charlie", "HR", 10500),
                new Employee("Diana", "HR", 11000),
                new Employee("Eve", "Sales", 11000)
        );

        Map<String, Long> result = HighEarnersCountByDep.highEarnersCountByDepartment(employees);

        assertEquals(1, result.get("IT"));
        assertEquals(2, result.get("HR"));
        assertEquals(1, result.get("Sales"));
    }

}