package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q9613 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            long result = 0;
            int n = Integer.parseInt(stk.nextToken());
            int[] nums = new int[n];

            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(stk.nextToken());
            }

            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    result += gcd(nums[j], nums[k]);
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
