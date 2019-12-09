package com.hw.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Question5 {

    public static void main(String[] args) {
        String[] s = {"abc", "321", "def", "122", "666", "xxy"};
        Pattern pattern = Pattern.compile("[0-9]*");
        Arrays.stream(s).filter( item -> pattern.matcher(item).matches()).sorted(Comparator.reverseOrder()).forEach(s1 -> System.out.println(Integer.valueOf(s1)));
    }
}
