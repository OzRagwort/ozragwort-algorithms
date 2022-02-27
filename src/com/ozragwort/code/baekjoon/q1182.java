package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1182 {

    static class Subsequence {

        private final int[] numbers;
        private final int s;

        public Subsequence(int[] numbers, int s) {
            this.numbers = numbers;
            this.s = s;
        }

        public int matchCount() {
            int count = 0;
            for (int i = 1; i <= numbers.length; i++) {
                count += matchCountDps(new boolean[numbers.length], i, 0, 0, 0);
            }
            return count;
        }

        private int matchCountDps(boolean[] visit, int depthStandard, int depth, int start, int sum) {
            if (depthStandard == depth) {
                if (sum == s) {
                    return 1;
                }
            }
            int count = 0;
            for (int i = start; i < numbers.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    count += matchCountDps(visit, depthStandard, depth + 1, i, sum + numbers[i]);
                    visit[i] = false;
                }
            }
            return count;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stk.nextToken());
        }
        Subsequence subsequence = new Subsequence(numbers, S);
        System.out.println(subsequence.matchCount());

        br.close();
    }
}
