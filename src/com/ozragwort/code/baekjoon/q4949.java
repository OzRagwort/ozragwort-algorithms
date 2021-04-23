package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q4949 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            } else {
                bw.write(check(s) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public String check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return "no";
                } else {
                    if (stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        return "no";
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
