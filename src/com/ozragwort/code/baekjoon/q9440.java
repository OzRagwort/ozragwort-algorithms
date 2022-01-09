package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q9440 {
	static class Pair {
		private static final int SIZE = 2;

		private int firstNumber = 0;
		private int secondNumber = 0;

		public Pair(int firstNumber, int secondNumber) {
			this.firstNumber = firstNumber;
			this.secondNumber = secondNumber;
		}

		public static int getSIZE() {
			return SIZE;
		}

		public int getFirstNumber() {
			return firstNumber;
		}

		public int getSecondNumber() {
			return secondNumber;
		}
	}

	static class Program {
		private static final int PAIR_SIZE = Pair.getSIZE();
		private static final int DECIMAL_RADIX = 10;
		private static final int FIRST_INDEX = 0;
		private static final int SECOND_INDEX = 1;

		private List<Integer> numbers = new ArrayList<>();

		public Program() {
		}

		public void add(int number) {
			numbers.add(number);
		}

		public void sort() {
			Collections.sort(numbers);
		}

		public int minPairSum() {
			Pair pair = getPair();
			return pair.getFirstNumber() + pair.getSecondNumber();
		}

		private Pair getPair() {
			int[] number = new int[PAIR_SIZE];
			int size = numbers.size();
			for (int i = 0; i < size; i++) {
				number[i % PAIR_SIZE] *= DECIMAL_RADIX;
				number[i % PAIR_SIZE] += getNextNumber(i);
			}
			return new Pair(number[FIRST_INDEX], number[SECOND_INDEX]);
		}

		private int getNextNumber(int index) {
			if (index < PAIR_SIZE) {
				int number = numbers.stream()
					.filter(integer -> integer != 0)
					.findFirst()
					.get();
				numbers.remove((Integer) number);
				return number;
			}
			int number = numbers.get(0);
			numbers.remove(0);
			return number;
		}

		public void clear() {
			numbers.clear();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Program program = new Program();
		String input = "";
		while ((input = br.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(input);
			int N = Integer.parseInt(stk.nextToken());
			if (N == 0) {
				break;
			}
			while (stk.hasMoreTokens()) {
				int number = Integer.parseInt(stk.nextToken());
				program.add(number);
			}
			program.sort();
			bw.write(program.minPairSum() + System.lineSeparator());
			program.clear();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
