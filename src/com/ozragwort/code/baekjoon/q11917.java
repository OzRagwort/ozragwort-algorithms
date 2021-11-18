package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q11917 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 0;

        if (M <= N) {
            for (int i = 1 ; i < M ; i++) {
                stk.nextToken();
            }
            result = Integer.parseInt(stk.nextToken());
        } else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0 ; i < N ; i++) {
                set.add(Integer.parseInt(stk.nextToken()));
            }

            List<Integer> list = new ArrayList<>(set);
            list.sort(Comparator.comparingInt(o -> o));
            result = M - N + set.size() - 1;

            for (int n : list) {
                if (n >= set.size()) {
                    result = Math.min(result, n);
                    break;
                }
            }
        }

        System.out.println(result);

        br.close();
    }

}
