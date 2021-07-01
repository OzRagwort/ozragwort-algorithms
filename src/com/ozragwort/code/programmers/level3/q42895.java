package com.ozragwort.code.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q42895 {
    HashMap<Integer, List<Integer>> dp;
    boolean[] visit;
    int number;

    public int solution(int N, int number) {
        dp = new HashMap<>();
        visit = new boolean[32001];
        this.number = number;

        for (int i = 1 ; i <= 8 ; i++) {
            dp.put(i, new ArrayList<>());
        }
        visit[0] = true;
        for (int i = 1 ; i * N <= 32000 ; i=i*10+1) {
            if (i * N == number) {
                return Integer.toString(i).length();
            }
            dp.get(Integer.toString(i * N).length()).add(i * N);
            visit[i * N] = true;
        }

        return dpCalc();
    }

    public int dpCalc() {
        int result = -1;

        for (int i = 2 ; i <= 8 ; i++) {
            for (int j = 1 ; j < i ; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        if (operation(a, b, i)) {
                            return i;
                        }
                    }
                }
            }
        }

        return result;
    }

    public boolean operation(int a, int b, int counter) {
        int add = a + b;
        int sub = a - b;
        int mul = a * b;
        int div = a / b;

        if (add == number || sub == number || mul == number || div == number) {
            return true;
        }

        if (dataCheck(add)) {
            visit[add] = true;
            dp.get(counter).add(add);
        }
        if (dataCheck(sub)) {
            visit[sub] = true;
            dp.get(counter).add(sub);
        }
        if (dataCheck(mul)) {
            visit[mul] = true;
            dp.get(counter).add(mul);
        }
        if (dataCheck(div)) {
            visit[div] = true;
            dp.get(counter).add(div);
        }

        return false;
    }

    public boolean dataCheck(int n) {
        return (0 <= n && n <= 32000) && !visit[n];
    }
}
