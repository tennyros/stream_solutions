package com.github.tennyros.solutions.stream_api.avg_employee_salary;

import com.github.tennyros.solutions.stream_api.grouping.avg_employee_salary.Solution;
import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private List<Employee> employees;

    @BeforeEach
    void initData() {
        employees = List.of(
                new Employee("John", "IT", 10_500),
                new Employee("Jane", "IT", 9_250),
                new Employee("Jessy", "IT", 8_700),
                new Employee("Base", "HR", 7_700),
                new Employee("Home", "HR", 10_700)
        );
    }

    @Test
    void testDepartmentToAverageSalary() {

        Map<String, Double> result = Solution.departmentToAverageSalary(employees);

        assertEquals(3, employees.stream().filter(e -> e.getDepartment().equals("IT")).count());
        assertEquals(2, employees.stream().filter(e -> e.getDepartment().equals("HR")).count());

        assertAll(
                () -> assertEquals(9483.33, result.get("IT"), 0.01),
                () -> assertEquals(9200.0, result.get("HR"), 0.01),
                () -> assertEquals(Map.of("HR", 9200.0, "IT", 9483.333333333334), result)
        );
    }

}