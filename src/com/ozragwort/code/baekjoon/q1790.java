package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1790 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        long length = 0;

        for (int i = 1 ; i <= 9 ; i++) {
            if (N >= Math.pow(10, i)) {
                length += (9 * Math.pow(10, i - 1)) * i;
            } else {
                length += (N - Math.pow(10, i - 1) + 1) * i;
                break;
            }
        }

        if (length < k) {
            System.out.println("-1");
        } else {
            int n = k;
            for (int i = 1 ; i <= 9 ; i++) {
                if (n > 9 * Math.pow(10, i - 1) * i) {
                    n -= 9 * Math.pow(10, i - 1) * i;
                } else {
                    int q = n / i;
                    int r = n % i;

                    int resultNum = (int) (Math.pow(10, i - 1) + q);
                    if (r == 0) {
                        resultNum -= 1;
                        r = r - 1 + i;
                    } else {
                        r = r - 1;
                    }

                    System.out.print(String.valueOf(resultNum).charAt(r));
                    break;
                }
            }
        }

    }
}
