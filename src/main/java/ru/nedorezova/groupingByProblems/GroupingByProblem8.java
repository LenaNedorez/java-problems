package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem8 {

    record Product(String category, double rating){}

    //Задача 8: Группировка продуктов по категории и получение среднего рейтинга для каждой категории
    //У вас есть список продуктов, каждый продукт имеет категорию и рейтинг.
    //Нужно сгруппировать продукты по категории и получить средний рейтинг для каждой категории.

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Electronics", 4.5),
                new Product("Books", 4.8),
                new Product("Electronics", 4.2),
                new Product("Books", 4.6),
                new Product("Clothing", 4.7)
        );

        Map<String, Double> averageRatingByCategory = getAverageRatingByCategory(products);

        System.out.println(averageRatingByCategory);
        // Вывод: {Clothing=4.7, Books=4.7, Electronics=4.35}
    }

    private static Map<String, Double> getAverageRatingByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::rating)));
    }
}
