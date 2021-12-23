package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2420 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		long M = Long.parseLong(stk.nextToken());
		long N = Long.parseLong(stk.nextToken());
		System.out.println(Math.abs(N - M));
		br.close();
	}
}
