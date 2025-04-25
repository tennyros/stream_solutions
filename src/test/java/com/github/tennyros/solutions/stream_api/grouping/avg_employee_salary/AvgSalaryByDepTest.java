package com.github.tennyros.solutions.stream_api.grouping.avg_employee_salary;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AvgSalaryByDepTest {

    @Test
    void shouldReturnAverageSalaryByDepartment() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 10000),
                new Employee("Bob", "IT", 12000),
                new Employee("John", "IT", 11000),
                new Employee("Charlie", "HR", 9000),
                new Employee("Diana", "HR", 9500),
                new Employee("Eve", "HR", 9200),
                new Employee("Frank", "Sales", 8000),
                new Employee("Grace", "Sales", 8500),
                new Employee("Hannah", "Sales", 8700),
                new Employee("Jack", "Marketing", 10500),
                new Employee("Kevin", "Marketing", 10200),
                new Employee("Liam", "Marketing", 10300),
                new Employee("Mia", "Finance", 12000),
                new Employee("Nina", "Finance", 12500),
                new Employee("Oliver", "Finance", 13000)
        );

        Map<String, Double> result = AvgSalaryByDep.averageSalaryByDepartment(employees);

        assertEquals(11000, result.get("IT"), 0.01);
        assertEquals(10333.33, result.get("Marketing"), 0.01);
    }
}