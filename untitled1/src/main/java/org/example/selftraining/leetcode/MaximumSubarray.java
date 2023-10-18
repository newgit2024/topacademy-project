package org.example.selftraining.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    static int maxArray (int [] arr){
        int sum = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < arr.length; i++){
            temp += arr[i];
            if (temp > sum){
                sum = temp;
            }
            if (temp < 0){
                temp = 0;
            }

        }
        return sum;
    }
    static int maxArray2 (int [] arr){
        int sum = arr[0];
        int temp = arr[0];

        for (int i = 0; i < arr.length; i++){
            temp = Math.max(arr[i], temp + arr[i]);
            sum = Math.max(temp, sum);

        }
        return sum;
    }

}
