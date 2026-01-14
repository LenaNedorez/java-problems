package ru.nedorezova.streamProblems;

import java.util.List;
import java.util.OptionalInt;

//Дан список целых чисел. Необходимо найти максимальное число в списке.

public class MaxFinder {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 5, 2, 8, 3);

        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue) // Преобразование в IntStream (для эффективной работы с примитивами int)
                .max(); // Нахождение максимального значения

        if (max.isPresent()) {
            System.out.println("Maximum value: " + max.getAsInt()); // Output: Maximum value: 8
        } else {
            System.out.println("List is empty");
        }
    }
}
