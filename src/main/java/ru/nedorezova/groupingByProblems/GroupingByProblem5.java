package ru.nedorezova.groupingByProblems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem5 {

    record Order(String customer, double total){}

    //Задача 5: Группировка с преобразованием значений в каждой группе
    //Дано: Список объектов Order с полями customer и total.
    //Задача: Сгруппировать заказы по имени клиента, и для каждого клиента получить список общей суммы его заказов.

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Alice", 150.0),
                new Order("Bob", 200.0),
                new Order("Alice", 75.0),
                new Order("Charlie", 300.0),
                new Order("Bob", 50.0)
        );

        Map<String, List<Double>> customerOrderTotals = getCustomerOrderTotals(orders);

        System.out.println(customerOrderTotals);
        // Вывод: {Bob=[200.0, 50.0], Charlie=[300.0], Alice=[150.0, 75.0]}
    }

    private static Map<String, List<Double>> getCustomerOrderTotals(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::customer, Collectors.mapping(Order::total, Collectors.toList())));
    }

}
