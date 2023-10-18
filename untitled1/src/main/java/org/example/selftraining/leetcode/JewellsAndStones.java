package org.example.selftraining.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//771
public class JewellsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

    }

    static int numJewelsInStones(String jewels, String s){
        int count = 0;
        Set<Character> settt = new HashSet<>();
        for (char c:jewels.toCharArray()) {
            settt.add(c);
        }
        for (char ch:s.toCharArray()) {
            if(settt.contains(ch)){
                count++;
            }
        }
        return count;


    }

}
