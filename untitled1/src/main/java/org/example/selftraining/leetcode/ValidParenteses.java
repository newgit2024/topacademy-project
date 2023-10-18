package org.example.selftraining.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenteses {
    public static void main(String[] args) {

    }

    static Map<String, String> dict = new HashMap<>();

    static {
        dict.put("(", ")");
        dict.put("{", "}");
        dict.put("[", "]");
    }

    private static boolean isValid(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            if (dict.containsKey(s.charAt(i))){
                if (!stack.isEmpty()){
                    var poppedEl = stack.pop();
                    if (!poppedEl.equals(dict.get(s.charAt(i)))){
                        return false;
                    }

                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }

            }
        }
        return stack.isEmpty();
    }
}

