package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1512 {

    int[][] dp = new int[3000][4];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String in = br.readLine().trim();
        char[] chars = new char[in.length()];
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < in.length() ; i++) {
            chars[i] = in.charAt(i);
        }

        for (int i = 1 ; i <= M ; i++) {
            int counter = fixCounter(chars, i);
            if (counter < min) {
                min = counter;
            }
        }

        System.out.println(min);
    }

    public int fixCounter(char[] chars, int M) {
        int result = 0;

        for (int i = 0 ; i < M ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                dp[i][j] = 0;
            }

            for (int j = i ; j < chars.length ; j+=M) {
                char a = chars[j];

                if (a == 'A') dp[i][0]++;
                else if (a == 'C') dp[i][1]++;
                else if (a == 'G') dp[i][2]++;
                else if (a == 'T') dp[i][3]++;

                result++;
            }

            result -= Math.max(
                    Math.max(dp[i][0], dp[i][1]),
                    Math.max(dp[i][2], dp[i][3])
            );
        }

        return result;
    }
}
