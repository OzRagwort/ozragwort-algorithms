package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q9012 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T ; i++) {
            String in = br.readLine();
            bw.write(VPS(in) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public String VPS(String in) {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0 ; j < in.length() ; j++) {
            if (in.charAt(j) == '(') {
                stack.push(0);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
