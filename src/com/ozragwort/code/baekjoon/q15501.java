package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q15501 {
	private static final String GOOD_PUZZLE = "good puzzle";
	private static final String BAD_PUZZLE = "bad puzzle";

	static class Numbers {
		private static final boolean SAME = true;
		private static final boolean NOT_SAME = false;

		private List<Integer> numbers;

		public Numbers(List<Integer> numbers) {
			this.numbers = new ArrayList<>(numbers);
		}

		public boolean compareTo(List<Integer> number, int start) {
			int size = number.size();
			for (int i = 0 ; i < size ; i++) {
				if (numbers.get(i).intValue() != number.get((i + start) % size).intValue()) {
					return NOT_SAME;
				}
			}
			return SAME;
		}
	}

	static class Puzzle {
		private static final boolean SAME_NUMBERS = true;
		private static final boolean NOT_SAME_NUMBERS = false;

		private Numbers numbers;
		private Numbers reverse;

		public Puzzle(List<Integer> number) {
			this.numbers = new Numbers(number);
			Collections.reverse(number);
			this.reverse = new Numbers(number);
		}

		public boolean isSame(List<Integer> number) {
			for (int i = 0; i < number.size(); i++) {
				if (numbers.compareTo(number, i) || reverse.compareTo(number, i)) {
					return SAME_NUMBERS;
				}
			}
			return NOT_SAME_NUMBERS;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		List<Integer> number = TokenToList(stk);
		Puzzle puzzle = new Puzzle(number);

		stk = new StringTokenizer(br.readLine());
		number = TokenToList(stk);

		String result = BAD_PUZZLE;
		if (puzzle.isSame(number)) {
			result = GOOD_PUZZLE;
		}
		System.out.println(result);

		br.close();
	}

	private List<Integer> TokenToList(StringTokenizer stk) {
		List<Integer> number = new ArrayList<>();
		while (stk.hasMoreTokens()) {
			number.add(Integer.parseInt(stk.nextToken()));
		}
		return number;
	}
}
