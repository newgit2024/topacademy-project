package org.example.selftraining.leetcode;

import java.util.Arrays;

//1470
public class ShuffleArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,3,4,7};
        int n = 3;

        var res = trueShuffleArray(arr, n);
        Arrays.stream(res).forEach(System.out::print);
    }

    private static int[] shuffleArray(int[] arr, int n) {
        int l = 0;
        int r = n + 1;
        //int[]res = new int[2 * n];
        int[]res = new int[arr.length];
        int cur = 0;
        while (l < n + 1 && r < 2 * n) {
            res[cur] = arr[l];
            res[cur+1] = arr[r];
            l++;
            r++;
            cur += 2;
            //cur++;
        }
        return res;

    }
    private static int[] trueShuffleArray(int[] arr, int n) {
        int[] res = new int[2 * n];
        int l = 0;
        int r = n;
        int cur = 0;

        while (l < n) {
            res[cur++] = arr[l];
            res[cur++] = arr[r];
            l++;
            r++;
        }

        return res;
    }

    private static int[] shuffleArray2(int[] arr, int n) {
        int l = 0;
        int r = n;
        int[]res = new int[arr.length];
        int cur = 0;
        for (int i = 1; i < arr.length; i += 2){
            res[i - 1] = arr[l];
            res[i] = arr[r];
        }
        return res;

    }
}
