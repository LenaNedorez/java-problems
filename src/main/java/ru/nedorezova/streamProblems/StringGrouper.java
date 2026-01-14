package ru.nedorezova.streamProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Дан список строк. Необходимо сгруппировать строки по их длине и получить Map<Integer, List<String>>,
// где ключ - длина строки, а значение - список строк этой длины.

public class StringGrouper {
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "kiwi", "orange", "grape");

        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length)); // Группировка по длине строки

        System.out.println(groupedByLength);
        // Output: {5=[apple, grape], 6=[banana, orange], 4=[kiwi]}
    }
}
