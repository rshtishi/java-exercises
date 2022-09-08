package com.github.rshtishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {
        String sentence = "Hello World How are you doing";
        List<String> letters = orderLetters(sentence);
        System.out.println(letters);
    }

    private static List<String> orderLetters(String sentence) {
        List<String> list = new ArrayList<>(Arrays.asList(sentence.split("")));
        list.removeIf(el -> el.equals("") || el.equals(" "));
        Collections.sort(list);
        return list;
    }
}
