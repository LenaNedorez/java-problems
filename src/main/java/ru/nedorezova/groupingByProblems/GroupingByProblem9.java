package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByProblem9 {

    //Задача 9: Группировка слов по первой букве и получение всех уникальных слов для каждой буквы
    //У вас есть список слов. Нужно сгруппировать слова по их первой букве
    //и получить Set всех уникальных слов, начинающихся с этой буквы.

    public static void main(String[] args) {
        List<String> words = List.of("apple", "ant", "banana", "ball", "cat", "car", "apple");

        Map<Character, Set<String>> wordsByFirstLetter = getWordsByFirstLetter(words);

        System.out.println(wordsByFirstLetter);
        // Вывод: {a=[apple, ant], b=[banana, ball], c=[cat, car]}
    }

    private static Map<Character, Set<String>> getWordsByFirstLetter(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.toSet()));
    }
}
