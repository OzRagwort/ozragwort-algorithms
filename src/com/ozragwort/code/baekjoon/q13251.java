package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q13251 {
	static class Pebble {
		private int[] pebble;

		public Pebble(int count) {
			pebble = new int[count];
		}

		public void set(int i, int count) {
			pebble[i] = count;
		}

		public int get(int i) {
			return pebble[i];
		}

		public int getSize() {
			return pebble.length;
		}

		public int getAllCount() {
			return Arrays.stream(pebble)
				.sum();
		}
	}

	static class Pebbles {
		public Pebbles() {
		}

		public double getAllSamePercentage(Pebble pebble, int k) {
			int allCount = pebble.getAllCount();
			int size = pebble.getSize();
			double[] percentages = new double[size];
			Arrays.fill(percentages, 1);

			for (double i = 0; i < k; i++) {
				for (int s = 0; s < size; s++) {
					percentages[s] *= (pebble.get(s) - i) / (allCount - i);
				}
			}
			return Arrays.stream(percentages)
				.sum();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Pebbles pebbles = new Pebbles();
		int M = Integer.parseInt(br.readLine());

		Pebble pebble = new Pebble(M);
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pebble.set(i, Integer.parseInt(stk.nextToken()));
		}

		int K = Integer.parseInt(br.readLine());
		double percentage = pebbles.getAllSamePercentage(pebble, K);
		System.out.println(percentage);

		bw.flush();
		bw.close();
		br.close();
	}
}
