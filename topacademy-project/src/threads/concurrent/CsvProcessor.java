package threads.concurrent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvProcessor {
    private final String fileName;

    public CsvProcessor(String fileName) {
        this.fileName = fileName;
    }

    public long countByPosition (int position, String value){
        long count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line = reader.readLine();
            while(line != null){
                String[] parts = line.split(",");
                if (parts[position].equals(value)){
                    count++;
                }
                line = reader.readLine();
            }
            return count;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
