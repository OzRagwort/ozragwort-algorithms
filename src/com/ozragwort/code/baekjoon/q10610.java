package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q10610 {
	static class Number {
		private String number;

		public Number(String number) {
			this.number = number;
		}

		public String getNumber() {
			return number;
		}

		public boolean isMultipleOfThirty() {
			if (hasZero()) {
				int sum = 0;
				for (int i = 0; i < number.length(); i++) {
					sum += charToInt(number.charAt(i));
				}
				return sum % 3 == 0;
			}
			return false;
		}

		private boolean hasZero() {
			return number.contains("0");
		}

		private int charToInt(char c) {
			return c - 48;
		}

		public void sort() {
			byte[] bytes = number.getBytes();
			Arrays.sort(bytes);
			number = new String(bytes);
		}

		public void sortReverse() {
			sort();
			number = new StringBuilder(number)
				.reverse()
				.toString();
		}
	}

	static class Thirty {
		public Thirty() {
		}

		public String getMax(Number number) {
			if (number.isMultipleOfThirty()) {
				number.sortReverse();
				return number.getNumber();
			}
			return "-1";
		}
	}

	static class InputView {
		public static Number readNumber() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			br.close();
			return new Number(input);
		}
	}

	static class OutputView {
		public static void println(String number) {
			System.out.println(number);
		}
	}

	public void solution() throws IOException {
		Number number = InputView.readNumber();
		Thirty thirty = new Thirty();
		OutputView.println(thirty.getMax(number));
	}
}
