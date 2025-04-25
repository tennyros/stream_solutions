package com.github.tennyros.solutions.stream_api.grouping.above_average_salaries;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AboveAvgSalariesTest {

    @Test
    void shouldReturnAboveAvgEmployeeSalaries() {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700)
        );

        List<String> result = AboveAvgSalaries.aboveAverageSalaries(employees);

        assertTrue(result.contains("Home"));
        assertTrue(result.contains("John"));
        assertFalse(result.contains("Jane"));
    }

    @Test
    void shouldReturnEmptyListWhenEmployeeListIsEmpty() {
        List<Employee> employees = List.of();

        List<String> result = AboveAvgSalaries.aboveAverageSalaries(employees);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldHandleOneEmployee() {
        List<Employee> employees = List.of(new Employee("John", "IT", 10_500));

        List<String> result = AboveAvgSalaries.aboveAverageSalaries(employees);

        assertTrue(result.contains("John"));
    }

}