package ionio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputDemo {
    public static void main(String[] args)  {
        try (FileOutputStream output = new FileOutputStream("storage\\output.txt", true)){
            output.write(48);
            byte[] value = {65, 77, 100};
            output.write(value);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
