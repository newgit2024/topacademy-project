package org.example.innotech.lukachepukhin;

public class SecondMaxArrayVal {
    public static int findElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least two elements.");
        }

        // Step 1: Find the maximum element in the array
        int maxElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxElement = nums[i];
            }
        }

        // Step 2: Find the maximum value that is less than the maximum element
        int maxLessThanMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < maxElement && num > maxLessThanMax) {
                maxLessThanMax = num;
            }
        }

        // Step 3: Check if a valid element was found
        if (maxLessThanMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No element found that is less than the maximum element.");
        }

        return maxLessThanMax;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 8, 3, 9, 6, 7 };
        try {
            int result = findElement(nums);
            System.out.println("Element less than the maximum but greater than the rest: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

