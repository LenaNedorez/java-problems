package ru.nedorezova.flatMapProblems;

import java.util.List;

public class flatMapProblem4 {

    record Order(int orderId, String itemName) {}
    record Customer(String name, List<Order> orders) {}

    //Задача 4: Извлечение всех заказов из списка клиентов
    //У нас есть список клиентов, где каждый клиент имеет список своих заказов.
    // Наша цель - получить общий список всех заказов.

    public static void main(String[] args) {


        List<Customer> customers = List.of(
                new Customer("John", List.of(new Order(101, "Laptop"), new Order(102, "Mouse"))),
                new Customer("Jane", List.of(new Order(201, "Keyboard"))),
                new Customer("Peter", List.of(new Order(301, "Monitor"), new Order(302, "Webcam")))
        );

        List<Order> allOrders = getAllOrders(customers);

        allOrders.forEach(order -> System.out.println(order.itemName() + " "+ order.orderId()));
       /*  Вывод:
        Laptop 101
        Mouse 102
        Keyboard 201
        Monitor 301
        Webcam 302
        */
    }

    private static List<Order> getAllOrders(List<Customer> customers) {
        return customers.stream().flatMap(customer -> customer.orders.stream()).toList();
    }
}
