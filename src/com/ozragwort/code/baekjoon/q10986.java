package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q10986 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());

		int[] count = new int[M];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum = (sum + Integer.parseInt(stk.nextToken())) % M;
			count[sum]++;
		}

		long result = count[0];
		for (int n : count) {
			result += ((long) n * (n - 1)) / 2;
		}

		System.out.println(result);

		br.close();
	}

}
