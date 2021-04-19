package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q3036 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1 ; i < N ; i++) {
            int gcd = gcd(Math.max(arr[0], arr[i]), Math.min(arr[0], arr[i]));
            bw.write((arr[0] / gcd) + "/" + (arr[i] / gcd) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
