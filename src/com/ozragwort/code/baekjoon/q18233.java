package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q18233 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);
        int E = Integer.parseInt(input[2]);

        int[][] members = new int[N][2];

        for (int i = 0 ; i < N ; i++) {
            String[] xy = br.readLine().split(" ");
            members[i][0] = Integer.parseInt(xy[0]);
            members[i][1] = Integer.parseInt(xy[1]);
        }

        List<Integer> caseList = check(members, new boolean[N], 0, P, E);
        if (caseList == null) {
            System.out.println("-1");
        } else {
            int[] result = getCase(members, caseList, 0, E);
            for (int r : result) {
                bw.write(r + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[] getCase(int[][] members, List<Integer> caseList, int vi, int E) {
        int[] result = new int[members.length];
        int sum = 0;

        for (int c : caseList) {
            result[c] = members[c][0];
            sum += members[c][0];
        }

        for (int i : caseList) {
            int max = members[i][1];

            while (result[i] < max && sum != E) {
                result[i]++;
                sum++;
            }
        }

        return result;
    }

    public List<Integer> check(int[][] members, boolean[] visit, int vi, int P, int E) {
        List<Integer> caseList = new ArrayList<>();

        if (P == 0) {
            int min = 0;
            int max = 0;
            for (int i = 0 ; i < visit.length ; i++) {
                if (visit[i]) {
                    min += members[i][0];
                    max += members[i][1];
                    caseList.add(i);
                }
            }
            if (min <= E && E <= max) {
                return caseList;
            }
        } else {
            for (int i = vi ; i <= visit.length - P ; i++) {
                visit[i] = true;
                caseList = check(members, visit, i + 1, P - 1, E);
                if (caseList != null) {
                    return caseList;
                }
                visit[i] = false;
            }
        }
        return null;
    }

}
