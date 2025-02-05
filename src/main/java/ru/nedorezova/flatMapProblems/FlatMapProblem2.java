package ru.nedorezova.flatMapProblems;

import java.util.Arrays;
import java.util.List;

public class FlatMapProblem2 {

    //Задача 2: Получение списка всех слов из списка предложений
    //У нас есть список предложений, где каждое предложение - это строка.
    //Нужно получить список всех уникальных слов, используемых во всех предложениях.

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "The quick brown fox",
                "jumps over the lazy dog",
                "the fox is very fast"
        );

        List<String> uniqueWords = selectUniqueWords(sentences);

        System.out.println(uniqueWords);
        // Вывод: [The, quick, brown, fox, jumps, over, the, lazy, dog, is, very, fast]
    }

    private static List<String> selectUniqueWords(List<String> sentences) {
        return sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .distinct()
                .toList();
    }

}