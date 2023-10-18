package org.example.inters.vladimirkutyavin;

import java.util.ArrayDeque;

class Stack {

    public static void main(String[] args) {
        String[] array = {"5", "2", "c", "d", "+"};


        System.out.println(calculateScores(array));

        //calculateScores2(array);

//d - *2 previous el
//c - delete previous
//+ - operation
//digits - scores
//LIFO


    }

    private static int calculateScores(String[] arr) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        int result = 0;


        for (String s : arr) {

            if (s.matches("\\d+")) {
                stack.push(s);
            } else if (s.equals("d")) {
                if (!stack.isEmpty()) {
                    int num = Integer.parseInt(stack.pop());
                    num *= 2;
                    stack.push(String.valueOf(num));
                }

            } else if (s.equals("c")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.equals("+")) {
                if (stack.size() >= 2) {
                    int prev = Integer.parseInt(stack.pop());
                    int preprev = Integer.parseInt(stack.pop());
                    result = prev + preprev;
                    stack.push(String.valueOf(result));
                }
            }


        }
        return Integer.parseInt(stack.pop());
    }


    private static int calculateScores2(String[] arr) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        int result = 0;

        for (String s : arr) {

            switch (s) {
                case "+":
                    int prev = Integer.parseInt(stack.pop());
                    int preprev = Integer.parseInt(stack.pop());
                    result = prev + preprev;
                    stack.push(String.valueOf(result));
                    break;
                case "d":
                    int num = Integer.parseInt(stack.pop());
                    num *= 2;
                    stack.push(String.valueOf(num));
                    break;
                case "c":
                    stack.pop();
                    break;
                default:
                    stack.push(s);
            }


        }
        return result;
    }
}


//Stack - валидация скобок??? открытые - три типа скобок




