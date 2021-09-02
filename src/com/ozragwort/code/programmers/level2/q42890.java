package com.ozragwort.code.programmers.level2;

import java.util.*;

public class q42890 {
    List<List<Integer>> lists = new ArrayList<>();
    List<List<Integer>> combinationCase = new ArrayList<>();

    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        int rowCount = relation.length;

        for (int i = 1 ; i <= columnCount ; i++) {
            combination(i, columnCount, new boolean[columnCount], new ArrayList<>());
        }

        HashSet<String> set = new HashSet<>();
        for (List<Integer> list : lists) {
            boolean minimality = true;

            for (List<Integer> combi : combinationCase) {
                if (list.containsAll(combi)) {
                    minimality = false;
                    break;
                }
            }

            if (minimality) {
                for (int i = 0 ; i < rowCount ; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer l : list) {
                        sb.append(relation[i][l]);
                        sb.append("/");
                    }
                    set.add(sb.toString());
                }
                if (set.size() == rowCount) {
                    combinationCase.add(list);
                }
                set.clear();
            }
        }

        return combinationCase.size();
    }

    public void combination(int len, int size, boolean[] visit, List<Integer> cases) {
        if (cases.size() == len) {
            lists.add(new ArrayList<>(cases));
        } else {
            for (int i = 0 ; i < size ; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    cases.add(i);
                    combination(len, size, visit, cases);
                    cases.remove((Integer) i);
                    visit[i] = false;
                }
            }
        }
    }
}
