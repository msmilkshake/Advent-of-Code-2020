package util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Util {
    public static String[] getInput(String path) {
        try {
            return Files.lines(Path.of(path)).toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
