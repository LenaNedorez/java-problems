package ru.nedorezova.groupingByProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByProblem11 {

    //Есть список новых данных, необходимо обновить существующие DTO на основе некоторого идентификатора.

    public static void main(String[] args) {
        // Существующие DTO
        List<UserDTO> existingUsers = Arrays.asList(
                new UserDTO(1, "Alice"),
                new UserDTO(2, "Bob")
        );

        // Новые данные
        List<UserDTO> newUsers = Arrays.asList(
                new UserDTO(2, "Robert"), // Обновление существующего пользователя
                new UserDTO(3, "Charlie") // Добавление нового пользователя
        );


        // Обновление существующих DTO с использованием Collectors.toMap
        Map<Integer, UserDTO> updatedUsersMap = existingUsers.stream()
                .collect(Collectors.toMap(
                        UserDTO::getId, // keyMapper: id пользователя
                        user -> user,    // valueMapper: сам UserDTO
                        (existing, replacement) -> { // mergeFunction: логика обновления
                            existing.setName(replacement.getName());
                            return existing;
                        }
                ));

        // Добавление новых пользователей
        newUsers.stream()
                .forEach(newUser -> updatedUsersMap.putIfAbsent(newUser.getId(), newUser));

        // Преобразование Map обратно в List
        List<UserDTO> updatedUsers = updatedUsersMap.values().stream().collect(Collectors.toList());

        updatedUsers.forEach(System.out::println);
    }

    static class UserDTO {
        private int id;
        private String name;

        public UserDTO(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "UserDTO{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
