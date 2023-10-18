package org.example.selftraining.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {

    }

    private static List<List<String>> groupAnagrams0(String[] strgs) {
        Map<String, List<String>> stringTypeToStringList = new HashMap<>();
        stringTypeToStringList.put(strgs[0], new ArrayList<>());

        for (int i = 0; i < strgs.length; i++) {
            if (stringTypeToStringList.containsKey(strgs[i])) {
                stringTypeToStringList.get(strgs[i]).add(strgs[i]);
            } else {
                List<String> values = new ArrayList<>();
                values.add(strgs[i]);
                stringTypeToStringList.put(strgs[i], values);
            }
        }
        return new ArrayList<>(stringTypeToStringList.values());
    }

    public static List<List<String>> trueGroupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Создаем массив символов из строки и сортируем его
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Добавляем строку в соответствующую группу (ключ - отсортированная строка)
            anagramGroups.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    // O(N* (k * log (k)) - N длина массива, k - длина максимального элемента - по времени
    //            ^
    //            |
    //        сортировка
    // O(n * k) - по сложности
    private  static List<List<String>> trueGroupAnagrams20(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            anagramGroups.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }


    // O(n * k) - N длина массива, k - длина максимального элемента - по времени
    //            ^
    //            |
    //        сортировка
    // O(n * k) - по памяти
    private  static List<List<String>> trueGroupAnagramsPro(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();
        int[]asciiKeyStorage = new int[26];

        for (String str : strs) {
            Arrays.fill(asciiKeyStorage, 0);
            for (char c:str.toCharArray()) {
                asciiKeyStorage[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < asciiKeyStorage.length; i++){
                sb.append('*');
                sb.append(asciiKeyStorage[i]);
            }

            String asciiKey = sb.toString();
            if(!anagramGroups.containsKey(asciiKey)){
                List<String> vals = new ArrayList<>();
                anagramGroups.put(asciiKey, vals);
            }
            anagramGroups.get(asciiKey).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }


    static List<List<String>> groupAnagramsCG10(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            anagramGroups.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }


   /* private static Map<Character[], List<String>> groupAnagrams(String[] strgs) {
        return Arrays.stream(strgs)
                .collect(Collectors.groupingBy(s -> s.chars().allMatch(c -> c == c), String::valueOf));

    }*/

    public List<List<String>> groupAnagramsCG(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));

        return new ArrayList<>(anagramGroups.values());
    }

    public List<List<String>> groupAnagramsCG2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> str.chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()));

        return new ArrayList<>(anagramGroups.values());
    }
}
