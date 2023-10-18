package org.example.selftraining.leetcode;

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("ABBBCDDEEEE"));
    }
    private static String compressString (String src){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = src.charAt(0);

        for (int i = 1; i < src.length(); i++){
            char cur = src.charAt(i);
            if (cur == prev){
                count++;
            } else {
                sb.append(prev).append(count);
                count = 1;
                prev = cur;
            }
        }

        sb.append(prev).append(count);
        return sb.toString();
    }

    public static String compressString2(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char prevChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);

            if (currChar == prevChar) {
                count++;
            } else {
                compressed.append(prevChar).append(count);
                count = 1;
                prevChar = currChar;
            }
        }

        compressed.append(prevChar).append(count);

        return compressed.toString();
    }

}
