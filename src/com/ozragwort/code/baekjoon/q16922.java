package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q16922 {
	static class RomanNumerals {
		private static int MAX_COUNT = 20;
		private static int I = 1;
		private static int V = 5;
		private static int X = 10;
		private static int L = 50;
		private static int MAX_SIZE = MAX_COUNT * L;
		private static int[] NUMERALS = new int[] {I, V, X, L};

		private boolean[][] possible;

		public RomanNumerals() {
			init();
			for (int i = 1; i <= MAX_COUNT; i++) {
				calcPossibleByCount(i);
			}
		}

		private void init() {
			possible = new boolean[MAX_COUNT + 1][MAX_SIZE + 1];
			possible[0][0] = true;
		}

		private void calcPossibleByCount(int count) {
			for (int i = MAX_SIZE; i >= 0; i--) {
				if (possible[count - 1][i]) {
					addPossible(count, i);
				}
			}
		}

		private void addPossible(int count, int i) {
			for (int numeral : NUMERALS) {
				if (i + numeral <= MAX_SIZE) {
					possible[count][i + numeral] = true;
				}
			}
		}

		public int getPossibleCount(int n) {
			int count = 0;
			for (boolean p : possible[n]) {
				if (p) {
					count++;
				}
			}
			return count;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		RomanNumerals romanNumerals = new RomanNumerals();
		int N = Integer.parseInt(br.readLine());
		System.out.println(romanNumerals.getPossibleCount(N));

		bw.flush();
		bw.close();
		br.close();
	}
}
