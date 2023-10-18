package org.example.inters.vladimirkutyavin;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FindTwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            numToIndex.put(nums[i], i);
        }

        return null; // Если нет такой пары
    }

    public static int[] findTwoSum2(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];
                    return numToIndex.containsKey(complement);
                })
                .mapToObj(i -> new int[]{numToIndex.get(target - nums[i]), i})
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
            System.out.println("Values: " + nums[result[0]] + ", " + nums[result[1]]);
        } else {
            System.out.println("No two elements sum up to the target.");
        }
    }
}

