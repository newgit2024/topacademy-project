package org.example.inters.vladimirkutyavin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LastWordLength {

    public static final String REGEX = " ";

    public static void main(String[] args) {
        System.out.println(lastWordLength("Hello Java Hi bye"));

    }

    private static int lastWordLength(String s) {
        //System.out.println();
        String[] strings = s.split(REGEX);
        int lengthToLastWordIndex = strings.length - 1;
        return (int) Arrays
                .stream(strings)
                .skip(lengthToLastWordIndex)
                .flatMapToInt(String::chars)
                .count();
    }


    public static int[] findTwoSum(int[] nums, int target) {
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
}
