package ru.nedorezova.stringProblems;

import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class stringProblem2 {

    //На вход приходит список списков зашифрованный строк, известно что в каждой зашифрованное строке находится 1 слово.
    // Необходимо расшифровать полученные данные и собрать их все в 1 строку, разделенную пробелами.
    //Дополнительное условие: известно, что в раскодированной строке присутствую лишние небуквенные символы.
    // Необходимо убрать эти символы из итоговой строки.

    public static void main(String[] args) {
        List<List<String>> lists = List.of(
                List.of("SGUxMTExbC0tMGxvMjEyMy4uLi8v", "dzBvcjFsZA=="),
                List.of("aW4=", "dGgxMTExMjMyaXM="),
                List.of("YmVhdXQxMjNpZjMxMnVs", "ZGF5"));

        String result = decodeAndClean1(lists);
        System.out.println(result);
    }

    public static String decodeAndClean(List<List<String>> lists) {
        return lists.stream()
                .flatMap(List::stream)
                .map(encodedString -> {
                    try {
                        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
                        return new String(decodedBytes);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Ошибка декодирования Base64: " + encodedString);
                        return "";
                    }
                })
                .map(str -> Pattern.compile("[^a-zA-Z]").matcher(str).replaceAll(""))
                .collect(Collectors.joining(" "));
    }

    public static String decodeAndClean1(List<List<String>> lists) {
        String decodedString = lists.stream().flatMap(List::stream)
        .map(s1 -> new String(Base64.getDecoder().decode(s1)))
        .collect(Collectors.joining(" "));

        return decodedString.replaceAll("[^A-Za-z\\s]", "");
    }

}
