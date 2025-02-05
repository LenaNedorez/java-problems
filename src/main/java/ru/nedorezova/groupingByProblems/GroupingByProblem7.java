package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem7 {

    record Employee(String name, String department){}

    //Задача 7: Группировка сотрудников по отделу и получение имен всех сотрудников в каждом отделе
    //У вас есть список сотрудников, каждый сотрудник имеет имя и отдел.
    //Нужно сгруппировать сотрудников по отделам и получить список имен всех сотрудников в каждом отделе.

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Alice", "Sales"),
                new Employee("Bob", "Engineering"),
                new Employee("Charlie", "Sales"),
                new Employee("David", "Engineering"),
                new Employee("Eve", "Marketing")
        );

        Map<String, List<String>> employeeNamesByDepartment = getEmployeeNamesByDepartment(employees);

        System.out.println(employeeNamesByDepartment);
        // Вывод: {Sales=[Alice, Charlie], Engineering=[Bob, David], Marketing=[Eve]}
    }

    private static Map<String, List<String>> getEmployeeNamesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())));
    }
}
