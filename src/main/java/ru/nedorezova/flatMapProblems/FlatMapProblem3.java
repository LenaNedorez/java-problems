package ru.nedorezova.flatMapProblems;

import java.util.List;

public class FlatMapProblem3 {
    //Задача 3: Извлечение всех элементов из списка списков целых чисел
    //У нас есть список списков целых чисел. Нужно получить один плоский список всех целых чисел.

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );

        List<Integer> allNumbers = getAllNumbers(listOfLists);

        System.out.println(allNumbers);
        // Вывод: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    private static List<Integer> getAllNumbers(List<List<Integer>> listOfLists) {
        return listOfLists.stream().flatMap(List::stream).toList();
    }
}
