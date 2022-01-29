package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1439 {
	static class Reverse {
		private static final String ZERO = "0";
		private static final String ONE = "1";

		public Reverse() {
		}

		public int getMinCount(String s) {
			int byZero = getSplitCountBy(s, ZERO);
			int byOne = getSplitCountBy(s, ONE);
			return Math.min(byZero, byOne);
		}

		private int getSplitCountBy(String s, String by) {
			String[] splits = s.split("[" + by + "]+");
			return (int)Arrays.stream(splits)
				.filter(split -> split.length() > 0)
				.count();
		}
	}

	static class InputView {
		public static String readLine() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			br.close();
			return input;
		}
	}

	static class OutputView {
		public static void outputCount(int count) {
			System.out.println(count);
		}
	}

	public void solution() throws IOException {
		String input = InputView.readLine();
		Reverse reverse = new Reverse();
		OutputView.outputCount(reverse.getMinCount(input));
	}
}
