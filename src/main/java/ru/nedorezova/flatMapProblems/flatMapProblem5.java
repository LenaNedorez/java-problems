package ru.nedorezova.flatMapProblems;

import java.util.List;

public class flatMapProblem5 {

    //Задача 5: Генерация всех пар из двух списков
    //Даны два списка. Необходимо сгенерировать все возможные пары,
    //где первый элемент взят из первого списка, а второй - из второго.

    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B", "C");
        List<Integer> list2 = List.of(1, 2, 3);

        List<String> allPairs = getAllPairs(list1, list2);

        System.out.println(allPairs);
        // Вывод: [A1, A2, A3, B1, B2, B3, C1, C2, C3]
    }

    private static List<String> getAllPairs(List<String> list1, List<Integer> list2) {
        return list1.stream().flatMap(str1 -> list2.stream().map(str2 -> str1 + str2)).toList();
    }


}
