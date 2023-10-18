package org.example.inters.vladimirkutyavin;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.*;

public class FindDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 5, 6, 7, 6, 8, 9};
        List<Integer> duplicates = findDuplicates(array);

        if (duplicates.isEmpty()) {
            System.out.println("Дубликатов нет.");
        } else {
            System.out.println("Дубликаты в массиве: " + duplicates);
        }
    }
}

