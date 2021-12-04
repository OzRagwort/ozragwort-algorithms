package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9095 {
	static class Calculator {
		private static final int MAX_VALUE = 10;
		private Integer[] sum = new Integer[MAX_VALUE + 1];

		public Calculator() {
			sum[0] = 0;
			sum[1] = 1;
			sum[2] = 2;
			sum[3] = 4;
		}

		public int getSumByNumber(int number) {
			if (sum[number] != null) {
				return sum[number];
			}
			return getSumByNumber(number - 1)
				+ getSumByNumber(number - 2)
				+ getSumByNumber(number - 3);
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calculator calculator = new Calculator();
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		for (int number : numbers) {
			int sum = calculator.getSumByNumber(number);
			System.out.println(sum);
		}
		br.close();
	}
}
