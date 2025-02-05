package ru.nedorezova;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningProblems {
    public static void main(String[] args) {

        //Задача 1: Конкатенация списка строк с разделителем
        //Дано: Список строк. Задача: Объединить все строки в одну, разделив их запятой и пробелом.

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        String result1 = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println(result1); // Вывод: Alice, Bob, Charlie, David


        //Задача 2: Конкатенация строк с префиксом и суффиксом
        //Дано: Список слов. Задача: Объединить слова в строку,
        //заключив ее в квадратные скобки, а слова разделить вертикальной чертой.

        List<String> words = List.of("apple", "banana", "cherry");

        String result2 = words.stream()
                .collect(Collectors.joining("|", "[", "]"));

        System.out.println(result2); // Вывод: [apple|banana|cherry]


        //Задача 3: Формирование SQL-запроса (IN clause)
        //Дано: Список ID. Задача: Сформировать строку, которая представляет собой IN-условие SQL-запроса: IN (1, 2, 3, 4)

        List<Integer> ids = List.of(1, 2, 3, 4, 5);

        String sqlInClause = ids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "IN (", ")"));

        System.out.println(sqlInClause); // Вывод: IN (1, 2, 3, 4, 5)


        //Задача 5: Конкатенация полей объекта в CSV-формате
        //Дано: Список объектов Person с полями name и age. Задача: Сформировать строку в CSV-формате,
        //где каждая запись (объект Person) находится в отдельной строке, а поля разделены запятой.

        record Person(String name, int age){}
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );


        String csvData = people.stream()
                .map(person -> person.name() + "," + person.age())
                .collect(Collectors.joining("\n"));

        System.out.println(csvData);
        /* Вывод:
           Alice,30
           Bob,25
           Charlie,35
        */
    }
}
