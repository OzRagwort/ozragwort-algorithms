package com.ozragwort.code.programmers.level3;

import java.util.*;

public class q17678 {
    public String solution(int n, int t, int m, String[] timetable) {
        int startTime = timeToInt("09:00");

        List<Integer> list = new ArrayList<>();
        for (String time : timetable) {
            list.add(timeToInt(time));
        }
        list.sort(Comparator.comparingInt(o -> o));

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0 ; i <= n ; i++) {
            map.put(i, new PriorityQueue<>((o1, o2) -> o2 - o1));
        }

        for (int l : list) {
            for (int i = 0 ; i < n ; i++) {
                int busTime = startTime + (t * i);
                if (l <= busTime) {
                    map.get(i).offer(l);
                    if (map.get(i).size() > m) {
                        l = map.get(i).poll();
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }

        String answer = "";
        PriorityQueue<Integer> lastQueue = map.get(n - 1);
        if (lastQueue.size() < m) {
            answer = intToTime(startTime + t * (n - 1));
        } else {
            answer = intToTime(lastQueue.poll() - 1);
        }

        return answer;
    }

    public int timeToInt(String time) {
        int[] hm = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return hm[0] * 60 + hm[1];
    }

    public String intToTime(int time) {
        String hour = String.format("%02d", time / 60);
        String minute = String.format("%02d", time % 60);
        return hour + ":" + minute;
    }
}
