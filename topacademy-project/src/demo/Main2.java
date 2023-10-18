package demo;

public class Main2 {
    public static void main(String[] args) {
       int i = 775;
       int[] arr = new int[3];
       arr[0] = 7;
       arr[1] = 8;
       arr[2] = 9;

       int[] arr2 = arr;
       // arr arr2
        //     |
        //   new array
        arr2[1] = 99;
        System.out.println(arr2[1]);

    }
}