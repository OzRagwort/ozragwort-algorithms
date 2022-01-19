package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q23351 {
	static class CatLeaf {
		public CatLeaf() {
		}

		public int getDayOfFirstDeath(int n, int k, int a, int b) {
			int[] days = calcDays(n, k, a, b);
			return Arrays.stream(days)
				.filter(value -> value > 0)
				.min()
				.getAsInt();
		}

		private int[] calcDays(int n, int k, int a, int b) {
			int size = n / a;
			int[] days = new int[size];
			for (int i = 0; i < size; i++) {
				int cycle = getCycle(size, k, i, b);
				days[i] = i + cycle * size;
			}
			return days;
		}

		private int getCycle(int size, int k, int i, int b) {
			int cycle = 0;
			while (k - i > 0) {
				k = k - (size - b);
				cycle++;
			}
			return cycle;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		CatLeaf catLeaf = new CatLeaf();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int day = catLeaf.getDayOfFirstDeath(N, K, A, B);
		System.out.println(day);

		bw.flush();
		bw.close();
		br.close();
	}
}
