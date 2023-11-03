package ionio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintDemo {
    public static void main(String[] args) {
        double[]doubles = {9.8, 3.14};
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("storage\\out.txt")))){
            for(double d : doubles){
                writer.printf("Constants %.2g%n", d);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
