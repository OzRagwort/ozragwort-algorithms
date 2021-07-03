package com.ozragwort.code.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;

public class q42839 {
    boolean[] prime;
    boolean[] visit;
    String[] num;
    StringBuilder sb = new StringBuilder();
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        num = new String[numbers.length()];
        prime = new boolean[10000000];
        visit = new boolean[numbers.length()];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        for (int i = 2 ; i * i < 10000000 ; i++) {
            for (int j = i + i ; j < 10000000 ; j+=i) {
                if (prime[j]) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 0 ; i < numbers.length() ; i++) {
            num[i] = numbers.substring(i, i+1);
        }

        for (int i = 0 ; i < num.length ; i++) {
            dfs(i, 0);
        }

        return set.size();
    }

    public void dfs(int i, int depth) {
        if (0 < depth && depth <= num.length) {
            if (prime[Integer.parseInt(sb.toString())]) {
                set.add(Integer.parseInt(sb.toString()));
            }
        }
        if (!visit[i]) {
            visit[i] = true;
            sb.append(num[i]);
            for (int next = 0 ; next < num.length ; next++) {
                dfs(next, depth + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }
}
