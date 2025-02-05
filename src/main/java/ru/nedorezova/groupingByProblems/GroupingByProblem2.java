package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem2 {

    record Person(String name, String city){}

    //Дано: Список объектов Person с полями name и city.
    // Задача: Сгруппировать людей по их городу проживания, создав Map,
    //где ключ - название города, а значение - список людей из этого города.

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Alice", "London"),
                new Person("Bob", "Paris"),
                new Person("Charlie", "London"),
                new Person("David", "New York"),
                new Person("Eve", "Paris")
        );

        Map<String, List<Person>> peopleByCity = getPeopleByCity(people);

        System.out.println(peopleByCity);
        /* Вывод:
        {Paris=[Person[name=Bob, city=Paris], Person[name=Eve, city=Paris]],
        London=[Person[name=Alice, city=London], Person[name=Charlie, city=London]],
        New York=[Person[name=David, city=New York]]}
        */
    }

    private static Map<String, List<Person>> getPeopleByCity(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::city));
    }
}
