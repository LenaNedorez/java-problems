package ru.nedorezova;
//Пример int[]{1,1,0,1,1,1,0} = 3

public class newClass {

    public static void main(String[] args) {
        int[] arr = {1, 0};
        System.out.println(biggestOne(arr));
    }

    public static int biggestOne (int[]  arr) {
        int current = 0;
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                current++;
            } else {
                current = 0;
            }
            max = Math.max(max, current);
        }

        return max;
    }
}
