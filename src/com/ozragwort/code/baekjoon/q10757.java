package com.ozragwort.code.baekjoon;

import java.io.*;
import java.math.BigInteger;

public class q10757 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");
        bw.write(String.valueOf(new BigInteger(nums[0]).add(new BigInteger(nums[1]))));
        bw.flush();
        bw.close();
        br.close();
    }
}
