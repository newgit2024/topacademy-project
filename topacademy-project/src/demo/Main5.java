package demo;

import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        int[] src = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(src));
        int[] dest = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(dest));
        int length = 3;
        int srcIndex = 1;
        int destIndex= 2;
        System.arraycopy(src, srcIndex, dest, destIndex, length);
        System.out.println(dest);
        System.out.println(Arrays.toString(dest));

        // dest[0] = src [0]; // 5 -> 1
    }
}
