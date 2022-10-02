package com.github.rshtishi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise28 {

    public static class CustomArrayList<E> extends ArrayList<E> {

        public List<E> getEveryNthElement(int startIndex, int skip){
            List<E> list =this.stream().skip(2).collect(Collectors.toList());
            list.removeIf(e -> list.indexOf(e)!=2 && list.indexOf(e)!=list.size()-1);
            this.clear();
            this.addAll(list);
            return this;
        }
    }

    public static void main(String[] args) {

        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        System.out.println(list.getEveryNthElement(2,3));
    }
}
