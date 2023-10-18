package org.example.inters.vladimirkutyavin;

import java.util.stream.IntStream;

public class SubStrings {

    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "abba";

        System.out.println(checkStrings(s1, s2));
        System.out.println(containsString(s2, s1)
        );


    }

    private static boolean checkStrings(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        } else {
            return IntStream.range(0, s1.length())
                    .allMatch(i -> s1.charAt(i) == s2.charAt(i));
        }
    }

    private static boolean checkSubString(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() < s2.length()) {
            return false;
        }


        if (s2.contains(s1)) {
            return true;
        } else {
            return false;
        }


    }


    public static boolean containsString(String mainString, String subString) {
        if (mainString == null || subString == null) {
            return false;
        }

        if (mainString.length() < subString.length()) {
            return false;
        }
        char[] mainChars = mainString.toCharArray();
        char[] subChars = subString.toCharArray();

        for (int i = 0; i <= mainChars.length - subChars.length; i++) {
            boolean found = true;
            for (int j = 0; j < subChars.length; j++) {
                if (mainChars[i + j] != subChars[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }

        return false;
    }






}
