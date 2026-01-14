package ru.nedorezova.streamProblems;

import java.util.List;
import java.util.stream.Collectors;

//Дан список строк. Необходимо объединить их в одну строку, разделяя их запятой.

public class StringJoiner {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Java", "Stream");

        String joinedString = words.stream()
                .collect(Collectors.joining(", ")); // Объединение строк с разделителем ", "

        System.out.println(joinedString); // Output: Hello, World, Java, Stream
    }
}
