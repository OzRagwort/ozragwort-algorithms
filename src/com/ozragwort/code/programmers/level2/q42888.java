package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q42888 {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for (String r : record) {
            String[] s = r.split(" ");

            if (s[0].equals("Enter")) {
                map.put(s[1], s[2]);
                list.add(s[0] + " " + s[1]);
            } else if (s[0].equals("Change")) {
                map.put(s[1], s[2]);
            } else {
                list.add(s[0] + " " + s[1]);
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0 ; i < list.size() ; i++) {
            String[] s = list.get(i).split(" ");

            if (s[0].startsWith("Enter")) {
                answer[i] = map.get(s[1]) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(s[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
