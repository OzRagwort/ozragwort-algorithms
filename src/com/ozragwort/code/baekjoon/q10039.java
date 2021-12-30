package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10039 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 5;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.max(40, Integer.parseInt(br.readLine()));
		}
		System.out.println(sum / n);

		br.close();
	}
}
