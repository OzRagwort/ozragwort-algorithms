package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class q17686 {
    public String[] solution(String[] files) {
        List<String[]> list = new ArrayList<>();

        for (String file : files) {
            String[] arr = file.split("[0-9]{1,5}");
            String HEAD = arr[0];

            String NUMBER = file.substring(HEAD.length()).split("[^0-9]")[0];
            NUMBER = NUMBER.substring(0, Math.min(NUMBER.length(), 5));
            list.add(new String[]{HEAD, NUMBER, file});
        }

        list.sort((o1, o2) -> {
            String i1 = o1[0].toLowerCase(Locale.ROOT);
            String i2 = o2[0].toLowerCase(Locale.ROOT);
            if (i1.equals(i2)) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            } else {
                return i1.compareTo(i2);
            }
        });

        String[] answer = new String[files.length];
        for (int i = 0 ; i < files.length ; i++) {
            answer[i] = list.get(i)[2];
        }
        return answer;
    }
}
