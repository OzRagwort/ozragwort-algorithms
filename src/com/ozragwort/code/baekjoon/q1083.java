package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1083 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(br.readLine());
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(stk.nextToken()));
		}

		while (S > 0 && numbers.size() > 0) {
			int maxIndex = findMaxIndex(numbers, Math.min(S, numbers.size() - 1));
			if (maxIndex == 0) {
				bw.write(numbers.remove((int) 0) + " ");
			} else {
				bw.write(numbers.remove((int) maxIndex) + " ");
				S -= maxIndex;
			}
		}

		for (int number : numbers) {
			bw.write(number + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private int findMaxIndex(List<Integer> numbers, int s) {
		int max = 0;
		int index = 0;
		for (int i = 0; i <= s; i++) {
			if (max < numbers.get(i)) {
				max = numbers.get(i);
				index = i;
			}
		}
		return index;
	}
}
