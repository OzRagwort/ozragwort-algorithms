package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1225 {

    static class WeirdMultiplication {

        public long calculate(String a, String b) {
            int[] array1 = toArray(a);
            int[] array2 = toArray(b);
            return mul(array1, array2);
        }

        private int[] toArray(String string) {
            return Arrays
                    .stream(string.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        private long mul(int[] array1, int[] array2) {
            long result = 0;
            for (int i : array1) {
                for (int j : array2) {
                    result += (long) i * j;
                }
            }
            return result;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        String a = stk.nextToken();
        String b = stk.nextToken();
        WeirdMultiplication multiplication = new WeirdMultiplication();
        System.out.println(multiplication.calculate(a, b));

        br.close();
    }
}
