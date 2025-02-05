package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem3 {

    //Задача 3: Группировка с подсчетом количества элементов в каждой группе
    //Дано: Список строк (названий продуктов).
    // Задача: Сгруппировать названия продуктов и подсчитать,
    // сколько раз каждое название встречается в списке.

    public static void main(String[] args) {
        List<String> products = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> productCounts = getProductCounts(products);

        System.out.println(productCounts);
        // Вывод: {orange=1, banana=2, apple=3}
    }

    private static Map<String, Long> getProductCounts(List<String> products) {
        return  products.stream()
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));
    }
}
