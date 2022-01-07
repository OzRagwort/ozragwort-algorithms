package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11536 {
	private static final String INCREASING = "INCREASING";
	private static final String DECREASING = "DECREASING";
	private static final String NEITHER = "NEITHER";

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] names = new String[N];
		for (int i = 0; i < N; i++) {
			names[i] = br.readLine();
		}

		String result = "";
		int standard = names[0].compareTo(names[1]);
		if (standard < 0) {
			result = INCREASING;
		} else {
			result = DECREASING;
		}
		for (int i = 2; i < N; i++) {
			int compareTo = names[i - 1].compareTo(names[i]);
			if (isSameSign(standard, compareTo)) {
				continue;
			}
			result = NEITHER;
			break;
		}
		System.out.println(result);

		br.close();
	}

	private boolean isSameSign(int a, int b) {
		return (long)a * b >= 0;
	}
}
