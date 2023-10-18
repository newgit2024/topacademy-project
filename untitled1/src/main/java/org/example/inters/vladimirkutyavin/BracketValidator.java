package org.example.inters.vladimirkutyavin;


import java.util.ArrayDeque;
import java.util.Deque;

public class BracketValidator {
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
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openingBracket = stack.pop();
                if (!isMatching(openingBracket, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}
