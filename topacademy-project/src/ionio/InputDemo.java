package ionio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class InputDemo {
    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("storage\\input.txt");
            int code = input.read();
            System.out.println(code + " char = " + (char) code);
            byte[] arr = new byte[16];
            int numBytes = input.read(arr);
            System.out.println(" num bytes " + numBytes);
            System.out.println(Arrays.toString(arr));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
