package ru.nedorezova.groupingByProblems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByProblem4 {

    record Product(String category, double price){}

    //Задача 4: Группировка с нахождением максимального значения в каждой группе
    //Дано: Список объектов Product с полями category и price.
    //Задача: Сгруппировать продукты по их категории и найти самый дорогой продукт в каждой категории.

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Electronics", 1200.0),
                new Product("Books", 25.0),
                new Product("Electronics", 800.0),
                new Product("Books", 30.0),
                new Product("Clothing", 50.0)
        );

        Map<String, Optional<Product>> mostExpensiveProductByCategory = getMostExpensiveProductByCategory(products);

        System.out.println(mostExpensiveProductByCategory);
        //Вывод: {Clothing=Optional[Product[category=Clothing, price=50.0]],
        // Books=Optional[Product[category=Books, price=30.0]],
        // Electronics=Optional[Product[category=Electronics, price=1200.0]]}
    }

    private static Map<String, Optional<Product>> getMostExpensiveProductByCategory(List<Product> products) {
        return  products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.maxBy(Comparator.comparingDouble(Product::price))
                ));
    }

}
