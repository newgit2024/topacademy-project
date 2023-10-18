package org.example.selftraining.leetcode;

import javax.naming.PartialResultException;
import java.util.Arrays;

//66
public class PlusOne {
    public static void main(String[] args) {


        Arrays.stream(plusOne2(new int[]{9,9,9})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(plusOne2(new int[]{1,2,3,4,5})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(plusOne2(new int[]{1,2,3,4,9})).forEach(System.out::print);
    }
    private static int[]plusOne(int[]nums){
        //9,9 + 1
        //  0  (1)
        //new 1, 0, 0
        //int count = 0;
        for (int i = nums.length - 1; i < 0; i--){
            if(nums[0] == 9 && nums[1] == 9){
                int[] res = new int[nums.length+1];
                res[0] = 1;
                for(int j = 1; j < res.length; j++){
                    res[j] = nums[i];
                }
            }
            if(nums[i] == 9){
                nums[i] = 0; //1
                nums[i-1]++;
            }

        }
        nums [nums.length - 1]++;
        return nums;
    }
    static int[] plusOne2(int[] digits) {
        int n = digits.length;
        //9,9,9

        // Инкрементируем последний элемент массива
        digits[n - 1] += 1; // 9, 9, 10

        // Обрабатываем возможные переполнения разряда
        for (int i = n - 1; i > 0 && digits[i] == 10; i--) { //i = 2
            digits[i] = 0; // 9, 9, 0
            digits[i - 1] += 1; // 9, 10, 0
        }

        // Если первый элемент тоже стал 10, то создаем новый массив
        if (digits[0] == 10) { // true {10, 0, 0}
            int[] result = new int[n + 1]; // arr[4]
            result[0] = 1; //{1,...}
            return result;
        }

        return digits;
    }


    static int[] plusOne3(int[] digits) {
        int index = digits.length -1;

        while (digits[index] == 9){
            digits[index] = 0;
            index--;
            if(index < 0){
                digits = new int[digits.length+1];
                digits[0] = 1;
                break;
            }
        }
        if(index >= 0){
            digits[index]++;
        }

        return digits;
    }
}
