package ru.nedorezova;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

//    public static void testBestTimeToBuyAndSellStock(){
////        int[] prices1 = {7,1,5,3,6,4};
////        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices1));
////        int[] prices2 = {7,6,4,3,1};
////        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices2));
////        int[] prices3 = {1, 2};
////        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices3));
//    }

//    public static void testFibonacciNumbers(){
//        System.out.println(FibonacciNumbers.);
//    }

//    public static void testBubbleSort() {
//        int[] arr1 = {1, 10, -9, 7, 8, 2, 5, 1, 6};
//        System.out.println(Arrays.toString(arr1));
//        Sorting.bubbleSort(arr1);
//        System.out.println(Arrays.toString(arr1));
//    }

//    public static void testBubbleSort2() {
//        int[] arr1 = {1, 10, -9, 7, 8, 2, 5, 1, 6};
//        System.out.println(Arrays.toString(arr1));
//        Sorting.bubbleSort(arr1);
//        System.out.println(Arrays.toString(arr1));
//    }

//    public static void testFindSecondBest() {
//        int[] arr1 = {1, 10, -9, 7, 8, 2, 5, 1, 4, 12};
//        System.out.println(Arrays.toString(arr1));
//        Integer i = FindSecondBest.findSecondMax(arr1);
//        System.out.println(i);
//        System.out.println(Arrays.toString(arr1));
//    }

    public static String testTreeNode() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        return root.toString();
    }

    public static void testInvertTreeNode(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(root.toString());
        InvertTreeNode.invertTree(root);
        System.out.println(root.toString());
    }
}