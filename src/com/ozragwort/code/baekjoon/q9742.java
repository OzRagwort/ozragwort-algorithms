package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class q9742 {
	static class Factorial {
		private Integer[] factorial;

		public Factorial(int size) {
			factorial = new Integer[size + 1];
			factorial[1] = 1;
		}

		public int getFactorial(int i) {
			if (factorial[i] != null) {
				return factorial[i];
			}
			factorial[i] = i * getFactorial(i - 1);
			return factorial[i];
		}
	}

	static class Permutation {
		private static final int MAX_SIZE = 10;
		private static final Factorial FACTORIAL = new Factorial(MAX_SIZE);
		private static final String NO_PERMUTATION = "No permutation";

		private String text = "";
		private int index = 0;

		public Permutation() {
		}

		public String getPermutation(String text, int index) {
			List<String> textList = new ArrayList<>(Arrays.asList(text.split("")));
			int factorial = FACTORIAL.getFactorial(text.length());

			if (isExceededIndex(factorial, index)) {
				return NO_PERMUTATION;
			}

			StringBuilder result = new StringBuilder();

			for (int i = 0; i < text.length(); i++) {
				factorial /= textList.size();
				int listIndex = (index - 1) / factorial;
				result.append(textList.remove(listIndex));
				index -= listIndex * factorial;
			}

			return result.toString();
		}

		private boolean isExceededIndex(int factorial, int index) {
			return factorial < index;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Permutation permutation = new Permutation();
		String input = "";
		while ((input = br.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(input);
			String text = stk.nextToken();
			int index = Integer.parseInt(stk.nextToken());
			String result = permutation.getPermutation(text, index);
			bw.write(input + " = " + result + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
