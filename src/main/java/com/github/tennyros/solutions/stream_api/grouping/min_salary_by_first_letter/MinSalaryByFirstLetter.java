package com.github.tennyros.solutions.stream_api.grouping.min_salary_by_first_letter;

import com.github.tennyros.solutions.stream_api.util.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class MinSalaryByFirstLetter {

    private MinSalaryByFirstLetter() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Находит минимальную зарплату среди сотрудников, чьи имена начинаются с указанной буквы.
     * <p>
     * Сравнение букв происходит без учёта регистра.
     * <p>
     * Если таких сотрудников нет, возвращается {@link Optional#empty()}.
     *
     * @param employees    список сотрудников
     * @param targetLetter буква, с которой должно начинаться имя сотрудника
     * @return {@link Optional} с минимальной зарплатой или пустой {@link Optional}, если подходящих сотрудников нет
     */
    public static Optional<Integer> minSalaryByFirstLetter(List<Employee> employees, char targetLetter) {
        return employees.stream()
                .filter(emp ->
                        Character.toLowerCase(emp.getName().charAt(0)) == Character.toLowerCase(targetLetter))
                .map(Employee::getSalary)
                .min(Comparator.comparingInt(Integer::intValue));
    }

    public static Optional<Integer> minSalaryByFirstLetterAlso(List<Employee> employees, char targetLetter) {
        return employees.stream()
                .filter(emp -> emp.getName()
                        .regionMatches(true, 0, String.valueOf(targetLetter), 0, 1))
                .map(Employee::getSalary)
                .min(Comparator.comparingInt(Integer::intValue));
    }

}
