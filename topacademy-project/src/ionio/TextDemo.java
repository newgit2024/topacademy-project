package ionio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class TextDemo {
    public static void main(String[] args) {
        //readStringOld();

        //readStringNew();
        //readStringNewest();
    }

    private static void readStringNewest() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("storage\\input.txt"))) {
            String collect = bufferedReader.lines().collect(Collectors.joining(":"));
            System.out.println(collect);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readStringNew() {
        String dir = "storage";
        String fileName = "input.txt";
        Path path = FileSystems.getDefault().getPath(dir, fileName);
        try {
            System.out.println(Files.readAllLines(path, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readStringOld() {
        String stringLines = "";
        try (FileReader reader = new FileReader("storage\\input.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String buf;
            while ((buf = bufferedReader.readLine()) != null) {
                stringLines += buf;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringLines);
    }
}
