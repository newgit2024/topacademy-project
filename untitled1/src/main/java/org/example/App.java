package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String result = "";

        for (int i = 1; i <= 100; i++) {

            try {
                result = fizzBuzz(i);
                System.out.println(result + " " + i);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }


    public static String fizzBuzz(int val) {

        if (val % 3 == 0 && val % 5 == 0) {
            return "fizzBuzz";
        } else if (val % 3 == 0) {
            return "fizz";
        } else if (val % 5 == 0) {
            return "buzz";
        } else {
            throw new IllegalArgumentException("не кратно ни одному числу");
        }
    }
}




