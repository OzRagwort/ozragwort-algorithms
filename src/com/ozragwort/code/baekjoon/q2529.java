package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2529 {
	static class Number {
		private long number = 0;

		public Number(long number) {
			this.number = number;
		}

		public Number(int[] numbers) {
			this.number = 0;
			for (int number : numbers) {
				this.number *= 10;
				this.number += number;
			}
		}

		public void set(Number number) {
			this.number = number.number;
		}

		public long compareTo(Number number) {
			return this.number - number.number;
		}

		public String getNumber(int digits) {
			String format = "%0" + digits + "d";
			return String.format(format, number);
		}
	}

	static class Sign {
		private int digits = 0;
		private Number max = new Number(0);
		private Number min = new Number(Long.MAX_VALUE);

		public Sign(String[] signs) {
			this.digits = signs.length + 1;
			int[] numbers = new int[signs.length + 1];
			boolean[] visit = new boolean[10];
			calc(signs, numbers, visit, 0);
		}

		private void calc(String[] signs, int[] numbers, boolean[] visit, int depth) {
			if (depth == numbers.length) {
				if (isPossible(signs, numbers)) {
					Number number = new Number(numbers);
					setNumbers(number);
				}
				return;
			}
			for (int i = 0; i <= 9; i++) {
				if (visit[i]) {
					continue;
				}
				numbers[depth] = i;
				visit[i] = true;
				calc(signs, numbers, visit, depth + 1);
				visit[i] = false;
			}
		}

		private void setNumbers(Number number) {
			if (max.compareTo(number) < 0) {
				max.set(number);
			}
			if (min.compareTo(number) > 0) {
				min.set(number);
			}
		}

		private boolean isPossible(String[] signs, int[] numbers) {
			for (int i = 0; i < signs.length; i++) {
				int a = numbers[i];
				int b = numbers[i + 1];
				String sign = signs[i];
				if (sign.equals("<") && a > b) {
					return false;
				}
				if (sign.equals(">") && a < b) {
					return false;
				}
			}
			return true;
		}

		public String getMax() {
			return max.getNumber(digits);
		}

		public String getMin() {
			return min.getNumber(digits);
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());
		String[] signs = br.readLine().trim().split(" ");
		Sign sign = new Sign(signs);
		System.out.println(sign.getMax());
		System.out.println(sign.getMin());

		bw.flush();
		bw.close();
		br.close();
	}
}
