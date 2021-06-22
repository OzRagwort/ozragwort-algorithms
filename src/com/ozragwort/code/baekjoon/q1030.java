package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1030 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int R1 = Integer.parseInt(stk.nextToken());
        int R2 = Integer.parseInt(stk.nextToken());
        int C1 = Integer.parseInt(stk.nextToken());
        int C2 = Integer.parseInt(stk.nextToken());
        int checkStart = (N - K) / 2;
        int checkEnd = checkStart + K;

        for (int i = R1 ; i <= R2 ; i++) {
            for (int j = C1 ; j <= C2 ; j++) {
                char result = check(i, j, s, N, checkStart, checkEnd) ? '1' : '0';
                bw.write(result);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean check(int i, int j, int s, int N, int start, int end) {
        for (int k = 0 ; k < s ; k++) {
            double di = (i % Math.pow(N, k + 1)) / Math.pow(N, k);
            double dj = (j % Math.pow(N, k + 1)) / Math.pow(N, k);
            if (start <= di && di < end && start <= dj && dj < end) {
                return true;
            }
        }
        return false;
    }
}
