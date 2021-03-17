package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1002 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            String[] S = br.readLine().split(" ");
            int x1 = Integer.parseInt(S[0]);
            int y1 = Integer.parseInt(S[1]);
            int r1 = Integer.parseInt(S[2]);
            int x2 = Integer.parseInt(S[3]);
            int y2 = Integer.parseInt(S[4]);
            int r2 = Integer.parseInt(S[5]);
            double dist = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2.0) + Math.pow(Math.abs(y1 - y2), 2.0));

            if (dist == 0 && (r1 == r2)) {
                bw.write("-1");
            } else if (Math.max(r1, r2) >= dist) {
                if (dist > Math.abs((r1 - r2))) {
                    bw.write("2");
                } else if (dist == Math.abs(r1 - r2)) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
            } else {
                if (dist < (r1 + r2)) {
                    bw.write("2");
                } else if (dist == (r1 + r2)) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
/*
0
r1, r2가 짧아서 교집합이 없을 때
X, Y의 거리 > r1 + r2
r1 또는 r2가 너무 길어서 교집합이 없을 때
if r1 or r2 길이 > dist
X, Y의 거리 < r1 - r2의 절대값

1
X, Y의 거리 = r1 + r2
if r1 or r2 길이 > dist
X, Y의 거리 = r1 - r2 의 절대값

2dist
X, Y의 거리 < r1 + r2
if r1 or r2 길이 > dist
X, Y의 거리 > r1 - r2의 절대값

 */