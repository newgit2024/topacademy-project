package org.example.innotech.trueview.rpkib.urakchincev;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Если встречается некорректная скобка
            }
        }
        return stack.isEmpty(); // Все скобки должны быть корректно закрыты
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));         // true
        System.out.println(isValid("(){}[]"));     // true
        System.out.println(isValid("(])"));        // false
        System.out.println(isValid("(())"));       // true
        System.out.println(isValid("([)]"));      // false

        System.out.println(isValidSymbols("()"));         // true
        System.out.println(isValidSymbols("(){}[]"));     // true
        System.out.println(isValidSymbols("(])"));        // false
        System.out.println(isValidSymbols("(())"));       // true
        System.out.println(isValidSymbols("([)]"));      // false
    }


    private static boolean isValidSymbols(String sequence) {
        Deque<Character> characters = new ArrayDeque<>();

        for (Character c : sequence.toCharArray()) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                characters.push(c);
            } else if (c.equals(')') || c.equals(']') || c.equals('}')) {
                if ((characters.peek().equals('(') || characters.peek().equals('[') || characters.peek().equals('{')) && !characters.isEmpty()) {
                    characters.pop();
                }
            } else {
                return false;
            }
        }

        return characters.isEmpty();
    }
}

