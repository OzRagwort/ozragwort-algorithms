package com.ozragwort.code.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class q42627 {
    public int solution(int[][] jobs) {
        List<int[]> jobList = new ArrayList<>(Arrays.asList(jobs));
        TreeSet<int[]> treeSet = new TreeSet<>((o1, o2) -> {
            // 작업 시간이 짧을수록 앞으로, 같으면 더 적게 기다린 작업 앞으로
            if (o1[1] == o2[1]) {
                if (o1[0] == o2[0]) {
                    return 1;
                } else {
                    return o2[0] - o1[0];
                }
            } else {
                return o1[1] - o2[1];
            }
        });

        int nowTime = 0;
        int allTime = 0;

        while (!jobList.isEmpty() || !treeSet.isEmpty()) {
            // 요청 시간이 되면 treeSet에 작업 추가
            int i = 0;
            while (i < jobList.size()) {
                int[] job = jobList.get(i);
                if (job[0] <= nowTime) {
                    treeSet.add(job);
                    jobList.remove(job);
                } else {
                    i++;
                }
            }
            if (!treeSet.isEmpty()) {
                // 가장 빠르게 끝날 작업부터 처리
                int[] next = treeSet.pollFirst();
                nowTime += next[1];
                allTime += nowTime - next[0];
            } else {
                // 작업이 없으면 시간 +1
                nowTime++;
            }
        }

        return allTime / jobs.length;
    }
}
