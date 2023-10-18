package org.example.selftraining.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(121));
    }


    static List<String> fizzBuzz(int num) {
        var res = new ArrayList();
        for (int i = 1; i < num; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Fizz");
            } else if (i % 3 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
