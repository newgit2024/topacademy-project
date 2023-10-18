package demo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        double pi = 3.14;
        int x = (int) pi;
        float f = x;
        int big = Integer.MAX_VALUE; //2147483647
        float f2 = big;

        long max = 2147483647L;
        int maxInt = (int) max;
        long max2 = 21474836470000L;
        int maxInt2 = (int) max2;

        System.out.printf("%f", f2);
        System.out.println(x);
        System.out.println(f);

        byte bMax = 127;
        bMax++; // bMax + 1
        System.out.println(bMax);

        boolean b1 = false;
        System.out.println(b1);

        b1 = Boolean.parseBoolean("TRUE");
        System.out.println(b1);

        int intSrc = 5;

        Integer integer = intSrc; // autoboxing

        int intTarget = integer; // unboxing

        //'b'.isUpperCase();
        Character.isUpperCase('b');

        Character.isDigit('7');

        final double CUSTOM_PI = 3.2;
        //CUSTOM_PI = 3.14;
    }
}