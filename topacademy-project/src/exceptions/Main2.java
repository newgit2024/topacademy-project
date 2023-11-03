package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(readFromFile("C:\\Users\\Bazis\\Desktop\\topacademy-project\\test.txt"));
    }

    public static double readFromFile(String filename) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        double num = 0;
        BufferedReader bufferedReader = null;

        try {
            FileReader reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
            String number = bufferedReader.readLine();
            num = numberFormat.parse(number).doubleValue();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return num;

    }


    public static double readFromFileImprov(String filename) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        double num = 0;

        try (FileReader reader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String number = bufferedReader.readLine();
            num = numberFormat.parse(number).doubleValue();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        return num;
    }
}