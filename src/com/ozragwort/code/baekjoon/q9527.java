package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q9527 {

    long[][] dp = new long[55][2];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine().trim());
        long A = Long.parseLong(stk.nextToken());
        long B = Long.parseLong(stk.nextToken());
        long[] bitCounter = new long[2];

        for (int i = 1 ; i < 55 ; i++) {
            dp[i][0] = dp[i - 1][1] + (long) Math.pow(2, i - 1);
            dp[i][1] = dp[i][0] + dp[i - 1][1];
        }

        bitCounter[0] = bitCounter(A - 1);
        bitCounter[1] = bitCounter(B);

        System.out.println(bitCounter[1] - bitCounter[0]);
    }

    public long bitCounter(long n) {
        int maxPower = power(n);
        long bit = dp[maxPower][1];

        if (n <= 1) {
            return n;
        } else {
            long divN = n - (long) Math.pow(2, maxPower);
            return bit + bitCounter(divN) + divN + 1;
        }
    }

    public int power(long n) {
        int power = 0;

        while (n > 1) {
            n /= 2;
            power++;
        }

        return power;
    }
}
