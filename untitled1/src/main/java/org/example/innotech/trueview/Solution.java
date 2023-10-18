package org.example.innotech.trueview;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        Integer a = 0;
        int b = 0;
        AtomicInteger c = new AtomicInteger(0);
        String d = "0";

        increment(a);

        increment(b);

        increment(c);

        increment(d);
        System.out.println(a); //1 //0
        System.out.println(b); //1 //0
        System.out.println(c); //1  //1
        System.out.println(d); //0
        System.out.println(increment2(a));
    }

    public static void increment(Integer a) {
        ++a;
    }

    public static int increment2(Integer a) {
        ++a;
        return a;
    }

    public static void increment(int b) {
        ++b;
    }

    public static void increment(AtomicInteger c) {
        c.incrementAndGet();
    }

    public static void increment(String d) {
        d = String.valueOf(
                Integer.parseInt(d) + 1);
    }
}
