package demo;

public class Main4 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            if (i >= 2) break;
            i++;
        }

        two: for (int n = 0; n < 10; n++) {
            for (int j = 10; j > 0; j--) {
                System.out.print(j - n + " ");
                if (j + n == 5 && n > 0)
                    break two;
            }
        }
    }
}
