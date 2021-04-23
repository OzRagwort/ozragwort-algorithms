package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10773 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0 ; i < K ; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        while (stack.size() > 0) {
            sum += stack.pop();
        }
        bw.write(Integer.toString(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}
