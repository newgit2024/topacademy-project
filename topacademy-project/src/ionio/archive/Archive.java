package ionio.archive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
    private String jarArchiveName;
    public static final int BUF = 2_048;

    public Archive(String jarArchiveName) throws FileNotFoundException {
        if(!jarArchiveName.endsWith(".jar")){
            throw new FileNotFoundException("Not found");
        }
        this.jarArchiveName = jarArchiveName;
    }

    public void zip(String dir) throws FileNotFoundException {
        Path path = Paths.get(dir);
        if (Files.notExists(path) || !Files.isDirectory(path)){
            throw new FileNotFoundException("Not found");
        }
        List<Path> fileList = null;
        try{
            fileList = Files.walk(path, 10)
                    .filter(f -> !Files.isDirectory(f))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path[] temp = {};
        Path[] array = fileList.toArray(temp);

        try (FileOutputStream outputStream = new FileOutputStream(jarArchiveName);
             JarOutputStream jarOutputStream = new JarOutputStream(outputStream)){
            byte[] buffer = new byte[BUF];
            jarOutputStream.setLevel(Deflater.DEFAULT_COMPRESSION);
            for (int i = 0; i < array.length; i++ ){
                String file = array[i].toString();
                jarOutputStream.putNextEntry(new ZipEntry(file));
                try(FileInputStream in = new FileInputStream(file)){
                    int len;
                    while ((len = in.read(buffer)) > 0){
                        jarOutputStream.write(buffer, 0, len);
                    }
                    jarOutputStream.closeEntry();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
