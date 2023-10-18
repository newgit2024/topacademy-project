package pv123;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Input arr size
                in console!!!
                """);
        int count = scanner.nextInt();

        /*
        var xxx = scanner.next();
        Integer.parseInt(xxx);
         */

        int[]maxs = new int[count];

        int curPair = 0;
        int countOfMaxs = 0;

        while (curPair < count){
            System.out.println("X = ");
            int x = scanner.nextInt();
            System.out.println("Y = ");
            int y = scanner.nextInt();

            if (x < y){
                System.out.println("X < Y");
                maxs[countOfMaxs] = y;
            } else if (x == y) {
                System.out.println("X = Y");
                maxs[countOfMaxs] = x;
            } else {
                System.out.println("X > Y");
                maxs[countOfMaxs] = x;
            }
            curPair++;
            countOfMaxs++;
        }

        for(int i = 0; i < maxs.length; i++){
            System.out.println(maxs[i]);
        }

    }
}
