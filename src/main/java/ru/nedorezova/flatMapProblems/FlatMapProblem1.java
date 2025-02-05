package ru.nedorezova.flatMapProblems;

import java.util.List;

public class FlatMapProblem1 {

    //Задача 1: Извлечение всех email-адресов из списка пользователей
    //Представим, что у нас есть список пользователей, где каждый пользователь имеет список своих email-адресов.
    // Наша задача - получить один плоский список, содержащий все email-адреса из всех пользователей.

    record User(String name, List<String> emails) {}

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alice", List.of("alice123@mail.com", "alice.work@corp.com")),
                new User("Bob", List.of("bob.coder@gmail.com")),
                new User("Charlie", List.of("charlie.test@test.org", "charlie_personal@mail.com"))
        );

        List<String> allEmails = getAllEmails(users);
        System.out.println(allEmails);
    }

    static List<String> getAllEmails(List<User> users){
        return users.stream().flatMap(user -> user.emails.stream()).toList();
    }

}
