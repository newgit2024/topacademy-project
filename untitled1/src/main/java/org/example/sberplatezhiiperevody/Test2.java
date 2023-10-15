package org.example.sberplatezhiiperevody;

public class Test2 {
    class A {
        String str = "ab";

        A() {
            printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }

    class B extends A {

        String str = " abc";

        /*
        void printLength() {
            System.out.println(str.length());
        }

         */

        @Override
        void printLength() {
            System.out.println(str.length());
        }
    }


    public static void main(String[] args) {
       new Test2().new B();
        //new B();

    }



    /*
    public static void main(String[] args) {
        new Test2().new B(); // Создание объекта класса B

        //.printLength();
        Test2 test2 = new Test2();
        test2.new A().printLength(); // Вызов метода printLength у объекта класса A

    }

     */

}

