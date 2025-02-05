package ru.nedorezova;

public class FindSecondBest {

    public static Integer findSecondMax(int[] array) {
        bSort(array);
        return array[array.length - 2];
    }

    public static void bSort(int[] array) {
        int n = array.length;
        for(int i = 0; i < n-1; i++){
            for(int j =0; j < n - i -1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
