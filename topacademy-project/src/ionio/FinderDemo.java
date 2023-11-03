package ionio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FinderDemo {
    static final int maxDepth = 5;
    public static void main(String[] args) {
        //countJava();
        //walkThroughSrc();

        statistics();
    }

    private static void statistics() {
        File file = new File ("storage" + File.separator + "input.txt");
        if(file.exists() && file.isFile()){
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.length());
            System.out.println(file.getParent());
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File dir = new File ("storage");
        if (dir.exists() && dir.isDirectory()){
            for(File cur : dir.listFiles()){
                System.out.println(cur.lastModified());
            }
            File root = File.listRoots()[0];
            System.out.println(root.getUsableSpace() + " " + root.getTotalSpace());
        }
    }

    private static void walkThroughSrc() {
        Path start = Paths.get("src");
        try (Stream<Path> walk = Files.walk(start, maxDepth)){
            walk.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countJava() {
        Path path = FileSystems.getDefault().getPath("src");
        if (Files.exists(path) && Files.isDirectory(path)){

            try (Stream<Path> pathStream = Files.find(path, maxDepth, (p, a) -> String.valueOf(p).endsWith(".java"))){
                long count = pathStream
                        .map(String::valueOf)
                        .peek(System.out::println)
                        .count();
                System.out.println(count);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
