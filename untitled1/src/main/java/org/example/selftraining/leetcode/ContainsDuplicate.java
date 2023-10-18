package org.example.selftraining.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//217
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate2(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate2(new int[]{1,2,3,4}));

    }



    private static boolean isContainsDuplicates(int[]nums){
        return Arrays.stream(nums).distinct().count() != nums.length;
    }




    static boolean containsDuplicate000(int[]arr){
        Arrays.sort(arr);
        int l = 0;
        int r = 1;
        while (l < arr.length - 1 && r < arr.length - 1){
            if (arr[l] == arr[r]){
                return true;
            }
            l++;
            r++;
        }
        return false;

    }


    static boolean containsDuplicate888(int[]arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i+1]){
                return true;
            }
        }
        return false;

    }











    static boolean containsDuplicate(int[]arr){
        return Arrays.stream(arr).distinct().count() != arr.length;

    }

    static boolean containsDuplicate2(int[]arr){
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            if (arr[l] == arr[r]){
                return true;
            }
            l++;
            r--;
        }
        return false;

    }

    static boolean containsDuplicate3(int[]arr) {
        var settt = new HashSet<Integer>();

        for (int i : arr) {
            if (!settt.add(i)) {
                return true;
            }
        }
        return false;
    }

}
