package com.ozragwort.code.programmers.level2;

import java.util.*;

public class q72412 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 전체 map 설정
        Map<String, List<Integer>> map = initMap();
        // -를 포함한 경우의 수 조합
        int[][] combination = initCombination();

        // map에 info 입력
        String[][] infos = new String[2][5];
        for (int i = 0; i < info.length ; i++) {
            infos[0] = new String[]{"-", "-", "-", "-"};
            infos[1] = info[i].split(" ");

            for (int[] com : combination) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0 ; c < 4 ; c++) {
                    sb.append(infos[com[c]][c]);
                }
                map.get(sb.toString()).add(Integer.parseInt(infos[1][4]));
            }
        }

        // sort
        for (String key : map.keySet()) {
            map.get(key).sort(Comparator.comparing(o -> o));
        }

        // 점수 탐색 및 경우의 수 구하기
        for (int i = 0 ; i < query.length ; i++) {
            String[] querys = query[i].replaceAll(" and ", "").split(" ");

            List<Integer> queryScore = map.get(querys[0]);

            int left = 0;
            int right = queryScore.size();
            int mid = (left + right) / 2;
            int targetScore = Integer.parseInt(querys[1]);

            while (left < right) {
                if (queryScore.get(mid) < targetScore) {
                    left = mid + 1;
                    mid = (left + right) / 2;
                } else {
                    right = mid;
                    mid = (left + right) / 2;
                }
            }

            answer[i] = queryScore.size() - mid;
        }

        return answer;
    }

    public Map<String, List<Integer>> initMap() {
        Map<String, List<Integer>> map = new HashMap<>();

        String[][] kind = new String[][]{
                {"java", "python", "cpp", "-"},
                {"backend", "frontend", "-"},
                {"junior", "senior", "-"},
                {"pizza", "chicken", "-"}
        };

        for (int a = 0 ; a < 4 ; a++) {
            for (int b = 0 ; b < 3 ; b++) {
                for (int c = 0 ; c < 3 ; c++) {
                    for (int d = 0 ; d < 3 ; d++) {
                        map.put(kind[0][a] + kind[1][b] + kind[2][c] + kind[3][d], new ArrayList<>());
                    }
                }
            }
        }

        return map;
    }

    public int[][] initCombination() {
        int[][] com = new int[16][4];

        for (int i = 0 ; i < 16 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                com[i][j] = i >> (3 - j) & 1;
            }
        }

        return com;
    }

//    class UserInfo {
//        String lang;
//        String part;
//        String career;
//        String soulFood;
//        int score;
//
//        UserInfo(String lang, String part, String career, String soulFood, int score) {
//            this.lang = lang;
//            this.part = part;
//            this.career = career;
//            this.soulFood = soulFood;
//            this.score = score;
//        }
//
//        public String getLang() {
//            return lang;
//        }
//
//        public String getPart() {
//            return part;
//        }
//
//        public String getCareer() {
//            return career;
//        }
//
//        public String getSoulFood() {
//            return soulFood;
//        }
//
//        public int getScore() {
//            return score;
//        }
//    }
//
//    public int[] solution(String[] info, String[] query) {
//        int[] answer = new int[query.length];
//
//        Map<Integer, UserInfo> userInfoMap = new HashMap<>();
//
//        String[][] kind = new String[][]{
//                {"java", "python", "cpp"},
//                {"backend", "frontend"},
//                {"junior", "senior"},
//                {"pizza", "chicken"}
//        };
//
//        Map<String, List<Integer>>[] list = new Map[4];
//        for (int i = 0 ; i < 4 ; i++) {
//            list[i] = new HashMap<>();
//            for (String kindDetail : kind[i]) {
//                list[i].put(kindDetail, new ArrayList<>());
//            }
//        }
//
//        for (int i = 0 ; i < info.length ; i++) {
//            String[] infos = info[i].split(" ");
//            userInfoMap.put(i, new UserInfo(
//                    infos[0],
//                    infos[1],
//                    infos[2],
//                    infos[3],
//                    Integer.parseInt(infos[4])
//            ));
//
//            for (int k = 0 ; k < 4 ; k++) {
//                list[k].get(infos[k]).add(i);
//            }
//        }
//
//        for (int i = 0 ; i < query.length ; i++) {
//            List<Integer> allList = new ArrayList<>(userInfoMap.keySet());
//            String[] queryDetail = query[i].split(" ");
//
//            for (int qi = 0 ; qi < 4 ; qi++) {
//                if (!queryDetail[qi * 2].equals("-")) {
//                    allList.retainAll(list[qi].get(queryDetail[qi * 2]));
//                }
//            }
//
//            allList.removeIf(key -> userInfoMap.get(key).getScore() < Integer.parseInt(queryDetail[7]));
//
//            answer[i] = allList.size();
//        }
//
//        return answer;
//    }
}
