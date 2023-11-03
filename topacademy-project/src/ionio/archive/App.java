package ionio.archive;

import lombok.SneakyThrows;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        String dir = "storage";
        Archive archive = new Archive("archive.jar");
        archive.zip(dir);
    }
}
