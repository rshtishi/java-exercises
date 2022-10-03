package com.github.rshtishi;

import java.io.*;

public class Exercise30 {

    public static void main(String[] args) throws IOException {
        String fileStr = "src/main/resources/test";
        File file = new File(fileStr);

        reverseFile(file);
    }

    private static void reverseFile(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exists");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String destFileName = stringBuilder.append(file.toPath().getFileName()).reverse().toString();
        String destFileStr = file.toPath().getParent().toString() + "/" + destFileName;
        File destFile = new File(destFileStr);
        BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder = new StringBuilder(line);
            writer.write(stringBuilder.reverse().toString());
            writer.newLine();
        }
        reader.close();
        writer.close();
    }


}
