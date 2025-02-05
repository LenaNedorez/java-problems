package ru.nedorezova;

public class newClass2 {
    public static void main(String[] args) {
        int[] arr = {5, -1, -3};
        System.out.println(subarray(arr));
    }

    //Найти подмассив с наибольшей суммой в массиве. Вывести результат
    // Пример массива new int[] {-3,-1,2,-1,1,1} = 3
    public static int subarray(int[] arr) {
        int sum = arr[0];
        int current = arr[0];

        for(int i = 1; i < arr.length; i++){
            current = Math.max(current + arr[i], arr[i]);
            sum = Math.max(sum, current);
        }

        return sum;
    }
}
