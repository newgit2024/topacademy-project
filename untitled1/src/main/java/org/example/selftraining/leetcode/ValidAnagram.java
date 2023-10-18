package org.example.selftraining.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

//242
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));

    }

    static boolean isAnagram(String s, String a) {
        if (s.length() != a.length()) {
            return false;
        }
        var sArr = s.toCharArray();
        var aArr = a.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(aArr);

        return String.valueOf(sArr).equals(String.valueOf(aArr));
        //return Arrays.equals(sArray, aArray);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!frequencyMap.containsKey(c) || frequencyMap.get(c) <= 0) {
                return false;
            }
            frequencyMap.put(c, frequencyMap.get(c) - 1);
        }

        return true;
    }

    public boolean isAnagram222(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyMap1 = new HashMap<>();
        Map<Character, Integer> frequencyMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count1 = frequencyMap1.getOrDefault(s.charAt(i), 0);
            frequencyMap1.put(s.charAt(i), ++count1);
            int count2 = frequencyMap2.getOrDefault(t.charAt(i), 0);
            frequencyMap2.put(t.charAt(i), ++count1);
        }

        return frequencyMap1.equals(frequencyMap2);
    }

    public boolean isAnagram1000(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Long> frequencyMap1 = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));

        Map<Character, Long> frequencyMap2 = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));

        return frequencyMap1.equals(frequencyMap2);
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;
    }

    public boolean isAnagram333(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isAnagram999(String s, String t) {
        // if the length of s and t is not equal return false
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hm1.containsKey(s.charAt(i))) {
                hm1.put(s.charAt(i), 1);
            } else {
                hm1.put(s.charAt(i), hm1.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!hm2.containsKey(t.charAt(i))) {
            } else {
                hm2.put(t.charAt(i), hm2.get(t.charAt(i)) + 1);
            }
        }
        for (Character ch : hm1.keySet()) {
            if (!hm1.get(ch).equals(hm2.get(ch))) {
                return false;
            }
        }
        return true;
    }



    static boolean isValid(String a, String t){
        if(a.length() != t.length()){
            return false;
        }
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char c : a.toCharArray()){
            if(!aMap.containsKey(c)){
                aMap.put(c, 1);
            } else {
                aMap.put(c, aMap.get(c) + 1);
            }
        }
        for(char c : t.toCharArray()){
            if(!tMap.containsKey(c)){
                tMap.put(c, 1);
            } else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }

        for(char c : aMap.keySet()){
            if (!aMap.get(c).equals(tMap.get(c))){
                return false;
            }
        }
        return true;

    }



}







