package ru.nedorezova.groupingByProblems;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem6 {

    record Order(LocalDate date, double totalAmount){}

    //Задача 6: Группировка заказов по дате и подсчет общей суммы для каждой даты
    //Представьте, что у вас есть список заказов, и каждый заказ имеет дату и общую сумму.
    //Нужно сгруппировать заказы по дате и вычислить общую сумму для каждой даты.

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order(LocalDate.of(2024, 1, 10), 100.0),
                new Order(LocalDate.of(2024, 1, 10), 150.0),
                new Order(LocalDate.of(2024, 1, 12), 200.0),
                new Order(LocalDate.of(2024, 1, 15), 50.0),
                new Order(LocalDate.of(2024, 1, 12), 75.0)
        );

        Map<LocalDate, Double> totalAmountByDate = getTotalAmountByDate(orders);

        System.out.println(totalAmountByDate);
        // Вывод: {2024-01-10=250.0, 2024-01-12=275.0, 2024-01-15=50.0}
    }

    private static Map<LocalDate, Double> getTotalAmountByDate(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::date,
                        Collectors.summingDouble(Order::totalAmount)
                ));
    }
}
