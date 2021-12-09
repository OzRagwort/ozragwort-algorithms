package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2475 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int sum = 0;
		while (stk.hasMoreTokens()) {
			int number = Integer.parseInt(stk.nextToken());
			sum += number * number;
		}
		System.out.println(sum % 10);
		br.close();
	}
}
