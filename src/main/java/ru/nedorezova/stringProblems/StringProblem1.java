package ru.nedorezova.stringProblems;

public class StringProblem1 {

    //На вход приходит номер телефона который начинается с +.
    // Необходимо маскировать цифры в номере, чтобы номер принял следующий вид: +NN**..**NN.
    // Количество звездочек должно соответствовать количеству замаскированных символов.

    public static void main(String[] args) {
        System.out.println(maskPhone("+79113456673"));
    }

    public static String maskPhone1(String phone) {
        return phone.replaceAll("(?<=...).(?=..)", "*");
    }

    public static String maskPhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() <= 3) {
            return phoneNumber; // Ничего не маскируем, если номер слишком короткий
        }

        int length = phoneNumber.length();
        int maskLength = length - 4; // Длина маскируемой части
        if (maskLength <= 0) {
            return phoneNumber; // Если номер слишком короткий для маскировки, возвращаем как есть
        }


        StringBuilder maskedNumber = new StringBuilder();
        maskedNumber.append(phoneNumber, 0, 2); // Сохраняем код страны
        for (int i = 0; i < maskLength; i++) {
            maskedNumber.append('*');
        }

        maskedNumber.append(phoneNumber.substring(length - 2)); // Добавляем последние две цифры
        return maskedNumber.toString();
    }
}
