package ru.nedorezova;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 1, 5, 2));

        List<Integer> sortedList1 = sortEvenNumbers(list);
        System.out.println("Отсортированный список: " + sortedList1); //Вывод: [3, 2, 1, 5, 4]

        List<Integer> sortedList2 = anotherWeirdSorting(list);
        System.out.println("Отсортированный список: " + sortedList2); //Вывод: [3, 2, 1, 5, 4]

        List<Integer> sortedList3 = sortEvenNumbersv2(list);
        System.out.println("Отсортированный список: " + sortedList3); //Вывод: [3, 2, 1, 5, 4]
    }

    public static List<Integer> sortEvenNumbers(List<Integer> list) {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> evenNumbers  = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                indexes.add(i);
                evenNumbers.add(list.get(i));
            }
        }
        Collections.sort(evenNumbers);
        for (int i = 0; i < evenNumbers.size(); i++) {
            list.set(indexes.get(i), evenNumbers.get(i));
        }
        return list;
    }

    public static List<Integer> anotherWeirdSorting(List<Integer> list) {
        List<Integer> evenNumbers = list.stream().filter(i -> i % 2 == 0).sorted().toList();
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, evenNumbers.get(j));
                j++;
            }
        }
        return list;
    }

    public static List<Integer> sortEvenNumbersv2(List<Integer> list) {
        // Разделяем список на четные и нечетные элементы.  Важное замечание:  этот метод
        // не изменяет исходный список.
        List<Integer> evenNumbers = list.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = list.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());


        // Сортируем четные числа по возрастанию.
        Collections.sort(evenNumbers);

        // Объединяем отсортированные четные и нечетные числа в новый список,
        // сохраняя порядок нечетных.  Используем индексы для вставки четных чисел в нужное место
        List<Integer> result = new ArrayList<>(oddNumbers);

        int evenIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                result.add(evenIndex, evenNumbers.get(evenIndex));
                evenIndex++;
            }
        }

        return result;


    }
}
