package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1022 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(stk.nextToken());
        int c1 = Integer.parseInt(stk.nextToken());
        int r2 = Integer.parseInt(stk.nextToken());
        int c2 = Integer.parseInt(stk.nextToken());

        int[][] result = new int[r2 - r1 + 1][c2 - c1 + 1];

        int[] wUp = new int[5001];
        int[] wLeft = new int[5001];
        int[] wDown = new int[5001];
        int[] wRight = new int[5001];

        wUp = makeWeight(wUp, wUp.length, 3);
        wLeft = makeWeight(wLeft, wLeft.length, 5);
        wDown = makeWeight(wDown, wDown.length, 7);
        wRight = makeWeight(wRight, wRight.length, 1);

        int max = 0;

        for (int i = 0 ; i < c2 - c1 + 1 ; i++) {
            for (int j = 0 ; j < r2 - r1 + 1 ; j++) {
                int x = c1 + i;
                int y = r1 + j;

                if (Math.abs(x) <= Math.abs(y)) {
                    if (y < 0) {
                        result[j][i] = + 1 + wUp[Math.abs(y)] - x;
                    } else {
                        result[j][i] = 1 + wDown[Math.abs(y)] + x;
                    }
                } else {
                    if (x < 0) {
                        result[j][i] = 1 + wLeft[Math.abs(x)] + y;
                    } else {
                        result[j][i] = 1 + wRight[Math.abs(x)] - y;
                    }
                }

                if (max < result[j][i]) {
                    max = result[j][i];
                }
            }
        }

        String format = "%" + Integer.toString(max).length() + "s";
        for (int i = 0 ; i < r2 - r1 + 1 ; i++) {
            for (int j = 0 ; j < c2 - c1 + 1 ; j++) {
                bw.write(String.format(format, result[i][j]) + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[] makeWeight(int[] arr, int r, int iv) {
        for (int i = 1 ; i < r ; i++) {
            arr[i] = arr[i - 1] + iv + (8 * (i - 1));
        }
        return arr;
    }
}
