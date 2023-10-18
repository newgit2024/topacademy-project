package org.example.sberplatezhiiperevody.two;

public class Test {
    static String str = "hello";

    public static String change(String s) {
        return "world";
    }

    public static void main(String[] args) {
        System.out.println(str);
        str = change(str);
        System.out.println(str);
    }
}

