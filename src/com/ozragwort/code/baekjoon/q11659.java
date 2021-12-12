package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q11659 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int[] numbers = new int[N + 1];
		long[] prefixSum = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
			prefixSum[i] = prefixSum[i - 1] + numbers[i];
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());

			long sum = prefixSum[end] - prefixSum[start - 1];
			bw.write(sum + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
