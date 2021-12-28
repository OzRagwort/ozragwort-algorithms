package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1120 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		String A = stk.nextToken();
		String B = stk.nextToken();
		int diffLength = B.length() - A.length();
		int minSameCharCount = Integer.MAX_VALUE;
		for (int i = 0; i <= diffLength; i++) {
			minSameCharCount = Math.min(minSameCharCount, getDiffCharCount(A, B.substring(i, i + A.length())));
		}
		System.out.println(minSameCharCount);

		br.close();
	}

	private int getDiffCharCount(String A, String B) {
		int count = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
