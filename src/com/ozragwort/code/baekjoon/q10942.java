package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10942 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N, M;
        int[] nums;
        Boolean[][] dp;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new Boolean[N][N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            if (dp[start - 1][end - 1] == null) {
                dp[start - 1][end - 1] = palindrome(nums, start, end);
            }
            bw.write(dp[start - 1][end - 1] ? "1\n" : "0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean palindrome(int[] nums, int start, int end) {
        for (int i = start ; i <= start + (end - start - 1) ; i++) {
            if (nums[i - 1] != nums[start + (end - i - 1)]) {
                return false;
            }
        }
        return true;
    }
}
