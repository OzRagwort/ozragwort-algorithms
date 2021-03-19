package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1018 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);
        char[][] table = new char[M][N];
        char[] colors = {'B', 'W'};
        int min = 64;

        for (int i = 0 ; i < M ; i++) {
            String buffer = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                table[i][j] = buffer.charAt(j);
            }
        }

        for (int i = 0 ; i <= M - 8 ; i++) {
            for (int j = 0 ; j <= N - 8 ; j++) {
                int minBuffer = 0;
                for (int x = i ; x < i + 8 ; x++) {
                    for (int y = j ; y < j + 8 ; y++) {
                        minBuffer += colors[(x + y) % 2] == table[x][y] ? 0 : 1;
                    }
                }
                min = Math.min(min, Math.min(minBuffer, 64 - minBuffer));
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }
}
