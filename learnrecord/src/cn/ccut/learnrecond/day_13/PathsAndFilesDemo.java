package cn.ccut.learnrecond.day_13;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsAndFilesDemo {
    @Test
    public void test01() throws IOException {
        Path path = Paths.get("E:\\123.jpg");
        System.out.println(Files.createFile(path));
    }
}
