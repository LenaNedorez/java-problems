package ru.nedorezova;

public class newClass3 {
    public static void main(String[] args) {
        System.out.println(summ(new double[]{1, 2, 3, 4, 5, 6}));
    }

    //int arr = {1, 2, 3, 4, 5, 6};
    //Поделите сумму первой половины элементов этого массива на сумму второй половины элементов.
    public static double summ (double[] arr) {

        if(arr == null) return 0;

        double sum1 = 0;
        double sum2 = 0;

        for(double i = 0, j = arr.length - 1; i < arr.length/2; i++, j--){
            sum1 = sum1 + arr[(int)i];
            sum2 = sum2 + arr[(int)j];
        }

        return sum1/sum2;
    }
}
