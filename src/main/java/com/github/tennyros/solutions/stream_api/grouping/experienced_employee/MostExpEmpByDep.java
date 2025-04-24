package com.github.tennyros.solutions.stream_api.grouping.experienced_employee;

import com.github.tennyros.solutions.stream_api.util.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сотрудник с наибольшим опытом в каждом департаменте
 * <br><br>
 * Условие:
 * <br>
 * У тебя есть список сотрудников List<Employee>. У каждого Employee есть:
 * <br>
 * - String name
 * <br>
 * - String department
 * <br>
 * - int yearsOfExperience
 * <br><br>
 * Нужно вернуть Map<String, String>, где ключ — это название департамента, а значение — имя самого опытного сотрудника в этом департаменте.
 * <br><br>
 * Если в департаменте несколько с одинаковым максимальным опытом — можно взять любого.
 * */
public class MostExpEmpByDep {

    public static void main(String[] args) {
        System.out.println(mostExperiencedEmployeeByDepartment(List.of(
                new Employee("John", "IT", 5),
                new Employee("Jane", "IT", 4),
                new Employee("Jessy", "IT", 5),
                new Employee("Base", "HR", 3),
                new Employee("Home", "HR", 3)
        )));
    }

    public static Map<String, String> mostExperiencedEmployeeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getYearsOfExperience)),
                                e -> e.map(Employee::getName).orElse("None")

                        )
                ));
    }

    @Getter
    @AllArgsConstructor
    private static class Employee {
        String name;
        String department;
        int yearsOfExperience;
    }
}
