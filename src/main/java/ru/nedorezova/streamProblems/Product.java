package ru.nedorezova.streamProblems;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Дан список объектов Product с полями name (String) и price (double).
//Необходимо отсортировать список по цене от самой низкой до самой высокой.

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 1200.0),
                new Product("Mouse", 25.0),
                new Product("Keyboard", 75.0),
                new Product("Monitor", 300.0)
        );

        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)) // Сортировка по цене (от меньшего к большему)
                .collect(Collectors.toList());

        System.out.println(sortedProducts);
        // Output: [Product{name='Mouse', price=25.0}, Product{name='Keyboard', price=75.0}, Product{name='Monitor', price=300.0}, Product{name='Laptop', price=1200.0}]
    }
}
