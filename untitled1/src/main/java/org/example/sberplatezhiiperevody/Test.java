package org.example.sberplatezhiiperevody;

public class Test {
    static String str =" hello";

    public static void change ( String s) {
        s = "world";
    }
    public static void main ( String [] args) {
        System.out.println();

        System.out.println(str);
        change(str);
        System.out.println(str);
    }
}
