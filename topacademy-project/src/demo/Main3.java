package demo;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        int [] numbers = new int[] { 3, 2, 1 };
        for (int number : numbers) {
            System.out.print(number + " ");
        }

       Scanner scanner = new Scanner(System.in);
       int count = scanner.nextInt();

       int[] max = new int[count];

       int currentPair = 0;
       int countOfMax = 0;

        System.out.println(count);
        int i = 0;


       while(currentPair < count){ // 0 -> 1... // 0 1 2 3 4 < 5
           System.out.println("INPUT X: ");
           int x = scanner.nextInt();
           System.out.println("INPUT Y: ");
           int y = scanner.nextInt();

           if (x < y) {
               System.out.println("X < Y");
               max[countOfMax] = y;
           } else if (x == y){
               System.out.println(" X = Y");
               max[countOfMax] = x;
           } else if (x > y) {
               System.out.println(" X > Y");
               max[countOfMax] = x; // 0 -> x
           }

           currentPair++; // i = i + 1; -> 5
           countOfMax++;
       }

       for (int j = 0; j < max.length; i++){
           System.out.println(max[j]);
       }

       /*
       for (;;){
           System.out.println(i);
       }

        */
    }
}