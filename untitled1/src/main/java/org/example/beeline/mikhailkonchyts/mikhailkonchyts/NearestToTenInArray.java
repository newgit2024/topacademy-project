package org.example.beeline.mikhailkonchyts.mikhailkonchyts;

import java.util.*;
import java.util.stream.IntStream;

public class NearestToTenInArray {


    private static int closestToTen(int[]nums){
        return Arrays.stream(nums)
                .boxed()
                .min(Comparator.comparing(num -> Math.abs(num - 10)))
                .orElse(0);
    }
    public static void main(String[] args) {
        System.out.println(closestToTen(new int[]{1,2,3,4,5,6}));

        System.out.println(findClosestNumber(new int[]{1,2,3,4,5,6,9,11}));

    }

    private static int nearestToTenInArray(int[] nums) {
        /*Arrays.stream(nums)
                .mapToObj(Integer::valueOf)
                .anyMatch(i -> i);


        IntStream.rangeClosed(0, nums.length)
                .filter(nums[i] -> Math.min(Math.abs(10 - nums[i])))
                .anyMatch*/
        return 0;
    }


    public static int findClosestNumber(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .min(Comparator.comparingInt(a -> Math.abs(a - 10)))
                .orElse(0);
    }


    public static int findClosestNumber2(Integer[] numbers) {
        return Optional.ofNullable(numbers)
                .map(num -> {
                    var set = new TreeSet<Integer>();
                    Collections.addAll(set, numbers);
                    return set.ceiling(10);
                })
                .orElse(-1);
    }


}

