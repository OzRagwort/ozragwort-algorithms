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

public class q10815 {
	private static final String HAS_NUMBER = "1 ";
	private static final String HAS_NOT_NUMBER = "0 ";

	static class Numbers {
		private List<Integer> numbers = new ArrayList<>();

		public Numbers() {
		}

		public void add(int number) {
			numbers.add(number);
		}

		public void sort() {
			Collections.sort(numbers);
		}

		public boolean contains(int number) {
			int left = 0;
			int right = numbers.size() - 1;
			int mid = (left + right) / 2;

			while (left < right) {
				if (numbers.get(mid) == number) {
					break;
				}
				if (numbers.get(mid) < number) {
					left = mid + 1;
					mid = (left + right) / 2;
					continue;
				}
				if (numbers.get(mid) > number) {
					right = mid;
					mid = (left + right) / 2;
				}
			}

			return numbers.get(mid) == number;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Numbers numbers = new Numbers();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(stk.nextToken()));
		}
		numbers.sort();

		int M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (numbers.contains(Integer.parseInt(stk.nextToken()))) {
				bw.write(HAS_NUMBER);
			} else {
				bw.write(HAS_NOT_NUMBER);
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
