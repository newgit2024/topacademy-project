package org.example.sberplatezhiiperevody.three;

public class Test2 {
    class A {
        String str = "ab";

        A() {
            //printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }

    class B extends A {
        String str = "abc";

        @Override
        void printLength() {
            System.out.println(str.length());
        }
    }

    public static void main(String[] args) {
        new Test2().new B().printLength();
    }
}
