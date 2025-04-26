package com.github.tennyros.solutions.stream_api.grouping.min_salary_by_first_letter;

import com.github.tennyros.solutions.stream_api.util.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MinSalaryByFirstLetterTest {

    @Test
    void shouldReturnMinSalaryByFirstLetter() {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 9000),
                new Employee("Adam", "HR", 11000),
                new Employee("Bob", "Engineering", 9500),
                new Employee("Barbara", "Sales", 10500)
        );

        char testLetterA = 'a';
        Optional<Integer> resultWithLetterA = MinSalaryByFirstLetter.minSalaryByFirstLetter(employees, testLetterA);

        char testLetterB = 'B';
        Optional<Integer> resultWithLetterB = MinSalaryByFirstLetter.minSalaryByFirstLetter(employees, testLetterB);

        assertAll(
                () -> assertEquals(Optional.of(9000), resultWithLetterA),
                () -> assertEquals(Optional.of(9500), resultWithLetterB)
        );
    }

}