package com.ozragwort.code.programmers.level3;

import java.util.*;

public class q43164 {
    List<String> list = new ArrayList<>();
    int ticketsLength;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ticketsLength = tickets.length;
        String startAirport = "ICN";

        HashMap<String, List<String>> map = new HashMap<>();

        // 입력 map에 넣기
        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new ArrayList<>());
            }
            map.get(t[0]).add(t[1]);
        }

        // 목적지 list 오름차순 정렬
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        // dfs로 경로 탐색
        dfs(map, startAirport, 0);

        // 경로 list to array
        answer = new String[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public boolean dfs(HashMap<String, List<String>> map, String airport, int i) {
        list.add(airport);

        if (ticketsLength == i) {
            return true;
        } else {
            if (map.containsKey(airport)) {
                List<String> nextAirports = new ArrayList<>(map.get(airport));

                for (String nextAirport : nextAirports) {
                    map.get(airport).remove(0);
                    if (dfs(map, nextAirport, i + 1)) {
                        return true;
                    }
                    map.get(airport).add(nextAirport);
                }
            }
            list.remove(i);
            return false;
        }
    }
}
