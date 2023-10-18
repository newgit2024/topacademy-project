package org.example;

public class LiveCoding2 {
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3,4};
        System.out.println(min(nums));


    }

    public static int min(int[]nums){
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            if (nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }


    public static int max(int[]nums){
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max;

    }
}
