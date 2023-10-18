package pv123new;

public class Main2 {
    public static void main(String[] args) {
        int i = 775;
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        //arr[3] = 4;

        int[]arr2 = arr;
        arr2[1] = 999;

        double x = 7 / 2;
        System.out.println(x);

        int t = 3;
        double y = t;
        double z = 9.5;
        int zzz = (int) z;
        System.out.println(zzz);

    }
}
