package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class q64065 {
    public int[] solution(String s) {
        List<String> sList = Arrays.asList(s.substring(2, s.length() - 2).split("},\\{"));
        sList.sort(Comparator.comparingInt(String::length));

        List<Integer> list = new ArrayList<>();

        for (String l : sList) {
            list.addAll(Arrays.stream(l.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        }

        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}
