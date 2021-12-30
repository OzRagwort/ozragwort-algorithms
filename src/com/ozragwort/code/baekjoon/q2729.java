package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class q2729 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(stk.nextToken(), 2);
			BigInteger B = new BigInteger(stk.nextToken(), 2);
			BigInteger sum = A.add(B);
			bw.write(sum.toString(2));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
