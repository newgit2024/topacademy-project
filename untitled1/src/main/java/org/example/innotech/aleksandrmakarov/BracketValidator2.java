package org.example.innotech.aleksandrmakarov;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BracketValidator2 {
    private static final Map<Character, Character> bracketPairs = new HashMap<>();

    static {
        bracketPairs.put('(', ')');
        bracketPairs.put('[', ']');
        bracketPairs.put('{', '}');
    }

    public static void main(String[] args) {
        String input = "({[()]})";
        boolean isValid = validateBrackets(input);

        if (isValid) {
            System.out.println("Brackets are valid.");
        } else {
            System.out.println("Brackets are invalid.");
        }
    }

    public static boolean validateBrackets(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (bracketPairs.containsKey(c)) {
                stack.push(c);
            } else if (bracketPairs.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char openingBracket = stack.pop();
                if (bracketPairs.get(openingBracket) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
