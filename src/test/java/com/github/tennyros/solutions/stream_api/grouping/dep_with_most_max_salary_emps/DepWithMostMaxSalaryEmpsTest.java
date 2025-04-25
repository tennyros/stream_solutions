package com.github.tennyros.solutions.stream_api.grouping.dep_with_most_max_salary_emps;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepWithMostMaxSalaryEmpsTest {

    /**
     * Проверяет, что метод возвращает IT как департамент
     * с наибольшим числом сотрудников, получающих максимальную зарплату.
     */
    @Test
    void shouldReturnDepartmentWithMostMaxSalaryEmployees() {
        List<Employee> employees = List.of(
                new Employee("Frank", "Stuff", 13000),
                new Employee("Hannah", "Stuff", 12000),
                new Employee("Irene", "Stuff", 13000),
                new Employee("Alice", "IT", 12000),
                new Employee("Bob", "IT", 13000),
                new Employee("Charlie", "IT", 13000),
                new Employee("David", "HR", 13000),
                new Employee("Eve", "HR", 12000),
                new Employee("Frank", "Sales", 13000),
                new Employee("Hannah", "Sales", 12000),
                new Employee("Irene", "Sales", 13000),
                new Employee("Frank", "Marketing", 13000),
                new Employee("Hannah", "Marketing", 12000),
                new Employee("Irene", "Marketing", 13000)
        );

        String result = DepWithMostMaxSalaryEmps.departmentWithMostMaxSalaryEmployees(employees);

        assertEquals("IT", result);
    }

}