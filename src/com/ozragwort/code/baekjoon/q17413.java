package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q17413 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean bracket = false;

        for (int i = 0 ; i < input.length() ; i++) {
            char c = input.charAt(i);

            if (c == ' ' || c == '<' || c == '>') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                if (c == '<') {
                    bracket = true;
                }
                if (c == '>') {
                    bracket = false;
                }

                sb.append(c);
            } else {
                if (bracket) {
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

}
