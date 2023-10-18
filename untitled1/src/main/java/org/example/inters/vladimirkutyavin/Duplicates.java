package org.example.inters.vladimirkutyavin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Duplicates {
    public static void main(String[] args) {
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 1};
        System.out.println(isDuplicate2(nums2));


        int[] nums = {1, 2, 3, 4, 2, 5, 6, 3};

        // Способ 1: Используя Set для поиска дубликатов
        boolean hasDuplicates1 = isHasDuplicates1(nums);

        System.out.println("Способ 1 - Имеются дубликаты: " + hasDuplicates1);

        // Способ 2: Используя distinct() и count() для сравнения с исходной длиной
        boolean hasDuplicates2 = isHasDuplicates2(nums);

        System.out.println("Способ 2 - Имеются дубликаты: " + hasDuplicates2);
    }

    private static boolean isHasDuplicates2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    private static boolean isHasDuplicates1(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        boolean hasDuplicates1 = Arrays.stream(nums)
                .anyMatch(num -> !uniqueSet.add(num));
        return hasDuplicates1;
    }

   /* private static boolean isDuplicate(int[] nums) {
        return IntStream.range(0, nums.length)
                .anyMatch(nums[i] ->{
            boolean result = nums[i] == nums[i + 1];

        });
    }*/


    private static boolean isDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int l = nums[0];
        int r = nums[nums.length-1];
        boolean res = false;
        while (l < r) {
            if (nums[l] == nums[r]) {
                res = true;
            }
            r--;
        }
        return res;
    }


    public static boolean hasDuplicates(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            if (!uniqueSet.add(num)) {
                return true; // Найден дубликат
            }
        }
        return false; // Дубликаты не найдены
    }


    /*private static boolean isDuplicate3(int[]arr){
        return Arrays.stream(arr)
                .anyMatch()
    }*/








}
