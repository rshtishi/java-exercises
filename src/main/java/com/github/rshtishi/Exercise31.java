package com.github.rshtishi;

import javax.xml.xpath.XPath;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise31 {

    public static void main(String[] args) throws IOException {

        String fileStr = "src/main/resources/test";
        File file = new File(fileStr);

        Map<String, Long> frequencyByWord = readFileContent(file);
        System.out.println(frequencyByWord);
        writeToFile(frequencyByWord);
    }

    private static void writeToFile(Map<String, Long> frequencyByWord) throws IOException {
        String fileStr = "src/main/resources/word_frequency";
        File file = new File(fileStr);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        frequencyByWord.entrySet().stream().forEach(e -> {
            try {
                writer.write(e.getKey() + ":" + e.getValue());
                writer.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        writer.close();

    }

    private static Map<String, Long> readFileContent(File file) throws IOException {
        Stream<String> lines = Files.lines(file.toPath());
        return lines.flatMap(line -> Stream.of(line.split(" "))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
