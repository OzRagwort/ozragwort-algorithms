package com.ozragwort.code.programmers.level3;

import java.util.*;

public class q42579 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, List<Integer[]>> map = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();

        for (int i = 0 ; i < genres.length ; i++) {
            // map에 key로 해당 카테고리가 없을 경우
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }

            // sum에 key로 해당 카테고리가 없을 경우
            if (!sum.containsKey(genres[i])) {
                sum.put(genres[i], 0);
            }

            map.get(genres[i]).add(new Integer[]{plays[i], i});
            sum.put(genres[i], sum.get(genres[i]) + plays[i]);
        }

        // map 정렬
        for (String category : map.keySet()) {
            map.get(category).sort((o1, o2) -> o2[0] - o1[0]);
        }

        // sum 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(sum.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < list.size() ; i++) {
            String category = list.get(i).getKey();
            List<Integer[]> sortedSongs = map.get(category);
            for (int j = 0 ; j < Math.min(2, sortedSongs.size()) ; j++) {
                result.add(sortedSongs.get(j)[1]);
            }
        }

        answer = new int[result.size()];
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
