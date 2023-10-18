package pv123;

import java.util.Scanner;

/**
 * Описание назначения класса
 * @author Yuri
 */

public class Main {
    public static void main(String[] args) {
        byte b = 127;
        int i = b;
        System.out.println(i);

        long l = 23_000_000_000L;
        int x = (int) l;

        System.out.println(x);

        int i2 = 10;
        double d = i2;

        System.out.println(d);

        extracted();

        // boolean const;

        final double CUSTOM_PI = 3.14;
        // CUSTOM_PI = 9.8;
        float f = 12f;

        char c = '\u0177';
        System.out.println(c);
        System.out.print(c);
        //System.out.printf("PI - %d", 3.14);
        // JDK1 -> JDK21

        System.out.println("PI = " + c);


        // создаем объект класса сканер и передаем
        // в конструктор стандартный поток вывода
        scan();
    }

    private static void scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
// возвращает истину, если введен целое число
        boolean isInt = scanner.hasNextInt();
        System.out.println(isInt);
// проверяем, являлось ли введенное значение
        // целым числом
        if (isInt){
            // считываем из консоли значение целого числа
            // в переименую x
            int x2 = scanner.nextInt();
            System.out.println("Вы ввели число" + x2);
        } else{
            System.out.println("Это не целое число");
        }
    }


    private static void extracted() {
        byte bMax = 127;
        bMax++;
        System.out.println(bMax);
    }
}
