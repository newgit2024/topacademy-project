package org.example.inters.leonidryzhik;

import java.util.Arrays;

public class FindPairsForSum {
    public static int[] findPairs(int[] nums, int targetSum) {
        // Сначала сортируем исходный массив
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == targetSum) {
                // Нашли пару чисел дающих в сумме целевое число
                return new int[]{nums[left], nums[right]};
            } else if (sum < targetSum) {
                // Если сумма меньше целевого числа, двигаем указатель слева вправо
                left++;
            } else {
                // Если сумма больше целевого числа, двигаем указатель справа влево
                right--;
            }
        }

        // Если не найдено пары чисел, возвращаем пустой массив
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12};
        int targetSum = 16;

        int[] result = findPairs(nums, targetSum);

        if (result.length == 2) {
            System.out.println("Числа дающие в сумме " + targetSum + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Пара чисел не найдена.");
        }
    }
}

