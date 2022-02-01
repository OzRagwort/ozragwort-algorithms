package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class q10817 {
	static class Numbers {
		private static final int MAX = 2;
		private static final int MIDDLE = 1;
		private static final int MIN = 0;

		private List<Integer> numbers = new ArrayList<>();

		public Numbers(int a, int b, int c) {
			numbers.add(a);
			numbers.add(b);
			numbers.add(c);
			numbers.sort(Comparator.comparingInt(o -> o));
		}

		public int max() {
			return numbers.get(MAX);
		}

		public int middle() {
			return numbers.get(MIDDLE);
		}

		public int min() {
			return numbers.get(MIN);
		}
	}

	static class InputView {
		private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		public Numbers readNumbers() throws IOException {
			StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			return new Numbers(a, b, c);
		}
	}

	static class OutputView {
		private final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		public OutputView() {
		}

		public void println(int x) {
			System.out.println(x);
		}

		public void println(String x) {
			System.out.println(x);
		}

		public void write(String x) throws IOException {
			bufferedWriter.write(x);
		}

		public void newLine() throws IOException {
			bufferedWriter.newLine();
		}

		public void flush() throws IOException {
			bufferedWriter.flush();
		}
	}

	public void solution() throws IOException {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		Numbers numbers = inputView.readNumbers();
		outputView.println(numbers.middle());
	}
}
