package org.example.innotech.lukachepukhin;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }

            numToIndex.put(nums[i], i);
        }

        return new int[]{}; // Если такая пара не найдена
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(nums, target);

        if (result != null) {
            System.out.println("Индексы чисел, сумма которых равна " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Пара чисел не найдена.");
        }
    }
}

