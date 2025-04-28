package com.github.tennyros.solutions.stream_api.grouping.emps_above_avg_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpsAboveAvgSalaryTest {

    @Test
    void shouldReturnEmployeesAboveAverageSalary() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 12_000),
                new Employee("Bob", "HR", 9_000),
                new Employee("Charlie", "IT", 11_000),
                new Employee("Diana", "Finance", 15_000),
                new Employee("Eve", "HR", 10_500),
                new Employee("Frank", "Finance", 8_500)
        );

        List<String> result = EmpsAboveAvgSalary.employeesAboveAverageSalary(employees);

        // Средняя зарплата сотрудников = 11_000
        assertEquals(List.of("Alice", "Diana"), result);
    }

}