package ru.nedorezova.streamProblems;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 17),
                new Person("Charlie", 30),
                new Person("David", 16),
                new Person("Eve", 22)
        );

        List<String> adultNames = people.stream()
                .filter(person -> person.getAge() > 18) // Фильтрация: оставляем только тех, кто старше 18
                .map(Person::getName)  // Преобразование: из Person в String (имя)
                .collect(Collectors.toList()); // Сбор в новый список

        System.out.println(adultNames); // Output: [Alice, Charlie, Eve]
    }
}