package com.github.tennyros.solutions.stream_api.grouping.above_median_salary_by_department;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.github.tennyros.solutions.stream_api.grouping.above_median_salary_by_department.AboveMedianSalaryByDep.aboveMedianSalaryByDepartment;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AboveMedianSalaryByDepTest {

    @Test
    void shouldReturnAboveMedianSalaryByDepartmentEmployees() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 28, 10000),
                new Employee("Bob", "IT", 24, 11000),
                new Employee("Charlie", "IT", 32, 9500),
                new Employee("David", "IT", 30, 11500),
                new Employee("Eve", "HR", 29, 10500),
                new Employee("Faythe", "HR", 31, 8700),
                new Employee("Grace", "HR", 27, 9400),
                new Employee("Heidi", "HR", 35, 9100),
                new Employee("Ivan", "Sales", 26, 12000),
                new Employee("Judy", "Sales", 28, 11800),
                new Employee("Karl", "Sales", 30, 10200),
                new Employee("Leo", "Sales", 33, 9800),
                new Employee("Mallory", "Finance", 29, 12500),
                new Employee("Niaj", "Finance", 31, 12200),
                new Employee("Olivia", "Finance", 34, 11700),
                new Employee("Peggy", "Finance", 28, 11900),
                new Employee("Quentin", "Marketing", 26, 8800),
                new Employee("Rupert", "Marketing", 27, 9000),
                new Employee("Sybil", "Marketing", 30, 9200),
                new Employee("Trent", "Marketing", 32, 8700)
        );

        /// Результатом будет: Sales=Judy, Ivan | Finance=Niaj, Mallory |
        /// HR=Grace, Eve | IT=Bob, David | Marketing=Rupert, Sybil
        Map<String, List<String>> result = aboveMedianSalaryByDepartment(employees);

        assertAll(
                () -> assertEquals(List.of("Judy", "Ivan"), result.get("Sales")),
                () -> assertEquals(List.of("Niaj", "Mallory"), result.get("Finance")),
                () -> assertEquals(List.of("Rupert", "Sybil"), result.get("Marketing"))
        );
    }

    @Test
    void shouldReturnEmptyList() {
        assertTrue(aboveMedianSalaryByDepartment(List.of()).isEmpty());
    }

}