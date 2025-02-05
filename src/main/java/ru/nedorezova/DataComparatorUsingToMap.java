package ru.nedorezova;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataComparatorUsingToMap {

    public static void main(String[] args) {
        List<Data> dataList = List.of(
                new Data("22", "1"),
                new Data("11", "3"),
                new Data("33", "1")
        );
        List<Data> dataList1 = List.of(
                new Data("11", "3"),
                new Data("22", "3"),
                new Data("33", "2")
        );

        System.out.println(findEditedData(dataList, dataList1));
        System.out.println(findEditedData1(dataList, dataList1));
    }

    public static List<String> findEditedData1(List<Data> dataList, List<Data> dataList1) {
        return Stream.of(dataList, dataList1).flatMap(List::stream)
                .collect(Collectors.toMap(Data::getCode, Data::getVersion, (exist, newVal)
                        -> exist.equals(newVal) ? null : exist)).entrySet().stream()
                .filter(entry -> entry.getValue() != null) .map(Map.Entry::getKey).toList();

    }


    public static List<String> findEditedData(List<Data> list1, List<Data> list2) {
        Map<String, Data> map1 = list1.stream()
                .collect(Collectors.toMap(Data::getCode, data -> data));
        Map<String, Data> map2 = list2.stream()
                .collect(Collectors.toMap(Data::getCode, data -> data));


        return map1.entrySet().stream()
                .filter(entry -> {
                    Data data2 = map2.get(entry.getKey());
                    return data2 != null && !entry.getValue().getVersion().equals(data2.getVersion());
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static class Data {
        String code;
        String version;

        public Data(String code, String version) {
            this.code = code;
            this.version = version;
        }

        public String getCode() {
            return code;
        }


        public String getVersion() {
            return version;
        }


        @Override
        public String toString() {
            return "Data{" +
                    "code='" + code + '\'' +
                    ", version='" + version + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Data data = (Data) o;
            return Objects.equals(code, data.code) && Objects.equals(version, data.version);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, version);
        }
    }
}
