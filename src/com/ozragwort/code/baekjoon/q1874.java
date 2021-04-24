package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1874 {

    int[] seq;
    int index = 0;
    Stack<Integer> stack = new Stack<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        seq = new int[N];

        for (int i = 0 ; i < N ; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        for (int num = 1 ; num <= N ; num++) {
            stack.push(num);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peek() == seq[index]) {
                stack.pop();
                index++;
                sb.append("-\n");
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

        br.close();
    }
}
