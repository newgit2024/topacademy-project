package org.example.selftraining.leetcode;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        var arr = new int[]{1,2,5,6,3,9};
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    static void sort(int[]arr){
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length-1; j++){
                if (arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
