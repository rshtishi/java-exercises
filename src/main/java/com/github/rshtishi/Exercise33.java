package com.github.rshtishi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise33 {

    public static void main(String[] args) throws IOException {

        String fileStr = "src/main/resources/photo";
        File file = new File(fileStr);
        List<String> allowedEndings = Arrays.asList("png", "jpg");
        displayPhoto(file, allowedEndings);
    }

    private static void displayPhoto(File file, List<String> allowedEndings) throws IOException {
        Files.walk(file.toPath()).filter(p -> checkEnding(p,allowedEndings)).forEach(System.out::println);
    }

    private static boolean checkEnding(Path p, List<String> allowedEndings) {
        String filename = p.getFileName().toString();
        if(filename.contains(".")){
            String ending = filename.substring(filename.lastIndexOf(".")+1);
            return allowedEndings.contains(ending);
        }
        return false;
    }
}
