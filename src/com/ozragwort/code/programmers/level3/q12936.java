package com.ozragwort.code.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class q12936 {

    long[] fac = new long[21];

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        fac[0] = fac[1] = 1;

        for (int i = 1 ; i <= n ; i++) {
            list.add(i);
        }

        for (int i = 0 ; i < n - 1 ; i++) {
            int index = (int) ((k - 1) / factorial(n - i - 1));
            answer[i] = list.get(index);
            list.remove((Object) answer[i]);
            k -= factorial(n - i - 1) * (index);
        }

        answer[n - 1] = list.get(0);

        return answer;
    }

    public long factorial(int n) {
        if (fac[n] == 0) {
            fac[n] = factorial(n - 1) * n;
        }
        return fac[n];
    }
}
