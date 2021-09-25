package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class q17677 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>(getList(str1));
        List<String> list2 = new ArrayList<>(getList(str2));

        List<String> universal = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        // 전체 구하기
        universal.addAll(list1);
        universal.addAll(list2);

        // 교집합 구하기
        for (String s1 : list1) {
            if (list2.contains(s1)) {
                list2.remove(s1);
                intersection.add(s1);
            }
        }

        // 합집합 구하기
        for (String i : intersection) {
            universal.remove(i);
        }

        return universal.isEmpty()
                ? 65536
                : (int) ((double) intersection.size() / universal.size() * 65536);
    }

    public List<String> getList(String str) {
        List<String> list = new ArrayList<>();

        for (int i = 0 ; i < str.length() - 1 ; i++) {
            String s = str.substring(i, i + 2).replaceAll("[^a-z]", "");
            if (s.length() == 2) {
                list.add(s);
            }
        }

        return list;
    }
}
