package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.Stack;

public class q10828 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < N ; i++) {
            String[] in = br.readLine().split(" ");

            if (in[0].equals("push")) {
                stack.push(Integer.parseInt(in[1]));
            } else if (in[0].equals("pop")) {
                if (stack.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (in[0].equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (in[0].equals("empty")) {
                if (stack.empty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                if (stack.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
