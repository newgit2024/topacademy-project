package org.example.selftraining.leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        //System.out.println(twoSum());
    }


    static int[] twoSum(int [] srcArray, int target) {
        Map<Integer, Integer> dict = new HashMap<>();


        for (int i = 0; i < srcArray.length; i++) {
            int complement = target - srcArray[i];
            if (dict.containsKey(complement)){
                return new int[]{dict.get(complement), i};
            }
            dict.put(srcArray[i],i);

        }

        return new int[]{};
    }
    public static int[] twoSum2(int[] srcArray, int target) {
        int[] sortedArray = Arrays.copyOf(srcArray, srcArray.length);
        Arrays.sort(sortedArray);

        int left = 0;
        int right = sortedArray.length - 1;

        while (left < right) {
            int sum = sortedArray[left] + sortedArray[right];
            if (sum == target) {
                // Нашли пару, находим индексы оригинальных элементов
                int index1 = indexOf(srcArray, sortedArray[left]);
                int index2 = indexOf(srcArray, sortedArray[right]);
                return new int[]{index1, index2};
            } else if (sum < target) {
                // Сумма меньше целевого значения, двигаем левый указатель
                left++;
            } else {
                // Сумма больше целевого значения, двигаем правый указатель
                right--;
            }
        }

        return new int[]{-1, -1}; // Если пара не найдена
    }

    public static int[] twoSum4(int[] srcArray, int target) {
        for (int i = 0; i < srcArray.length - 1; i++) {
            for (int j = i + 1; j < srcArray.length; j++) {
                if (srcArray[i] + srcArray[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Если пара не найдена
    }

    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // Если элемент не найден
    }


    public static int[] twoSum10(int[] srcArray, int target){
        for(int i = 0; i < srcArray.length - 1; i++){
            for(int j = i + 1; j < srcArray.length; j++){
                if(srcArray[i] + srcArray[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }




}
