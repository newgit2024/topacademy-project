package org.example.selftraining.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    static boolean isPalindrome(int num){
        String numStr = String.valueOf(num);

        return numStr.equals(new StringBuilder(numStr).reverse().toString());

    }

    static boolean isPalindrome2(int num){
        if (num < 0 || ( num % 10 == 0 && num != 0) ){
            return false;
        }
        int buf = 0;
        while (num > buf){
            buf = buf * 10 + num % 10;
            num /= 10;
        }

        return num == buf;

    }
}
