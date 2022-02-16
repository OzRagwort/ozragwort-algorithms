package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1343 {

    static class Polyomino {

        private static final String AAAA = "AAAA";
        private static final String BB = "BB";
        private static final String FAIL_MESSAGE = "-1";

        public String generate(String input) {
            String[] splits = input.split("\\.", -1);
            String[] result = new String[splits.length];
            for (int i = 0; i < splits.length; i++) {
                int A = splits[i].length() / AAAA.length();
                int B = (splits[i].length() - (A * AAAA.length())) / BB.length();
                int remainder = splits[i].length() - A * AAAA.length() - B * BB.length();
                if (remainder != 0) {
                    return FAIL_MESSAGE;
                }
                result[i] = AAAA.repeat(A) + BB.repeat(B);
            }
            return String.join(".", result);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Polyomino polyomino = new Polyomino();
        System.out.println(polyomino.generate(br.readLine()));

        br.close();
    }
}
