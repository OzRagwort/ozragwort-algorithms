package com.ozragwort.code.baekjoon;

import java.io.*;
import java.math.BigInteger;

public class q10757 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while(N > 0) {
            String[] num = br.readLine().split(" ");
            BigInteger counter = BigInteger.ZERO;
            BigInteger nowPosition = BigInteger.ZERO;
            BigInteger speed = BigInteger.ZERO;
            BigInteger dist = new BigInteger(num[1]).subtract(new BigInteger(num[0]));
            while(dist.divide(BigInteger.valueOf(2)).compareTo(nowPosition.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE)) == 1) {
                nowPosition.add(speed);
                speed.add(BigInteger.ONE);
            }

            N--;
        }

        String[] nums = br.readLine().split(" ");
        bw.write(String.valueOf(new BigInteger(nums[0]).add(new BigInteger(nums[1]))));
        bw.flush();
        bw.close();
        br.close();
    }
}
