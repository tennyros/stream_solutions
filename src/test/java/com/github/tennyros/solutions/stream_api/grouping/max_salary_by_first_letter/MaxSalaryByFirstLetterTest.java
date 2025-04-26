package com.github.tennyros.solutions.stream_api.grouping.max_salary_by_first_letter;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSalaryByFirstLetterTest {

    @Test
    void shouldReturnMaxSalaryByFirstLetter() {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 12000),
                new Employee("Jane", "IT", 12000),
                new Employee("Jessy", "IT", 9000),
                new Employee("Max", "HR", 8000),
                new Employee("Alex", "HR", 9500)
        );

        Map<Character, Integer> result = MaxSalaryByFirstLetter.maxSalaryByFirstLetter(employees);

        assertEquals(12000, result.get('J'));
        assertEquals(8000, result.get('M'));
        assertEquals(9500, result.get('A'));
    }

}