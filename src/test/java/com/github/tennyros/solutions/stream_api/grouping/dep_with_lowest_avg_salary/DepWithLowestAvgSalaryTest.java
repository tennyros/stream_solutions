package com.github.tennyros.solutions.stream_api.grouping.dep_with_lowest_avg_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepWithLowestAvgSalaryTest {

    @Test
    void shouldReturnDepartmentWithLowestAverageSalary() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "IT", 12000),
                new Employee("Charlie", "HR", 9000),
                new Employee("Diana", "HR", 9500),
                new Employee("Eve", "Sales", 8000),
                new Employee("Frank", "Sales", 8500)
        );

        String result = DepWithLowestAvgSalary.departmentWithLowestAverageSalary(employees);

        assertEquals("Sales", result);
    }

}