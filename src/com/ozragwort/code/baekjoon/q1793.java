package com.ozragwort.code.baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class q1793 {

    BigInteger[] dp = new BigInteger[251];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        List<Integer> input = new ArrayList<>();
        int max = 0;

        String s = "";
        while ((s = br.readLine()) != null) {
            int in = Integer.parseInt(s);
            max = Math.max(max, in);
            input.add(in);
        }

        for (int i = 2 ; i <= max ; i++) {
            dp[i] = dp[i - 2]
                    .multiply(BigInteger.valueOf(2))
                    .add(dp[i - 1]);
        }

        for (int n : input) {
            bw.write(dp[n].toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
