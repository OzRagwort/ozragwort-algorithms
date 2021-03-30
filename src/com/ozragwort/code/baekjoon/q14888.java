package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q14888 {

    int N;
    int[] arr;
    int[] calc;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        calc = new int[4];
        int depth = 0;

        // 수열
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // 사칙연산
        stk = new StringTokenizer(br.readLine());
        calc[0] = Integer.parseInt(stk.nextToken());
        calc[1] = Integer.parseInt(stk.nextToken());
        calc[2] = Integer.parseInt(stk.nextToken());
        calc[3] = Integer.parseInt(stk.nextToken());

        for (int i = 0 ; i < 4 ; i++) {
            func(depth, i, arr[0]);
        }

        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int depth, int index, int value) {
        if (depth == (N - 1)) {
            if (max < value)
                max = value;
            if (min > value)
                min = value;
        } else {
            if (calc[index] != 0) {
                if (index == 0) {
                    value = sum(value, arr[depth + 1]);
                } else if (index == 1) {
                    value = sub(value, arr[depth + 1]);
                } else if (index == 2) {
                    value = mul(value, arr[depth + 1]);
                } else {
                    value = div(value, arr[depth + 1]);
                }
                calc[index]--;
                depth++;
                for (int i = 0 ; i < 4 ; i++) {
                    func(depth, i, value);
                }
                calc[index]++;
            }
        }
    }

    public int sum(int a, int b) {
        return (a + b);
    }

    public int sub(int a, int b) {
        return (a - b);
    }

    public int mul(int a, int b) {
        return (a * b);
    }

    public int div(int a, int b) {
        return (a / b);
    }

}
