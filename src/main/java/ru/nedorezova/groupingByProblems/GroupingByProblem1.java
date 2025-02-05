package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem1 {

    //Задача 1: Группировка списка слов по длине
    //Дано: Список слов. Задача: Сгруппировать слова по их длине, создав Map,
    //где ключ - длина слова, а значение - список слов этой длины.

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "kiwi", "grape", "melon", "pear");

        Map<Integer, List<String>> wordsByLength = groupByLength(words);

        System.out.println(wordsByLength);
        // Вывод: {4=[kiwi, pear], 5=[apple, grape, melon], 6=[banana]}

    }

    private static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }
}
