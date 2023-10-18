package org.example.selftraining.leetcode;

public class PowXN {
    public static void main(String[] args) {
        System.out.println(powXN(3, 3));

    }

    static double powXN(double x, int n) {
        double ans = 1.0;
        long num = n;
        if (n < 0) {
            num = (-1) * num;
        }
        while (num > 0) {
            if (num % 2 == 0) {
                ans = x * x;
                num /= 2;
            } else {
                ans = ans * x;
                num -= 1;
            }
        }
        if (n < 0) {
            ans = 1 / ans;
        }
        return ans;
    }
}
