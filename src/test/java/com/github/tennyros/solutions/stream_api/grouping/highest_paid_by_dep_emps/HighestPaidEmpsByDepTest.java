package com.github.tennyros.solutions.stream_api.grouping.highest_paid_by_dep_emps;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HighestPaidEmpsByDepTest {

    @Test
    void shouldReturnHighestPaidEmployeesByDepartment() {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 12000),
                new Employee("Jane", "IT", 12000),
                new Employee("Jessy", "IT", 9000),
                new Employee("Max", "HR", 8000),
                new Employee("Alex", "HR", 9500)
        );

        Map<String, List<String>> result = HighestPaidEmpsByDep.highestPaidEmployeesByDepartment(employees);

        assertEquals(List.of("John", "Jane"), result.get("IT"));
        assertEquals(List.of("Alex"), result.get("HR"));
    }

}