package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2920 {
	class CMajorScale {
		private static final String ASCENDING_MESSAGE = "ascending";
		private static final String DESCENDING_MESSAGE = "descending";
		private static final String MIXED_MESSAGE = "mixed";

		private final int[] ascending = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		private final int[] descending = new int[] {8, 7, 6, 5, 4, 3, 2, 1};

		public CMajorScale() {
		}

		public String compareTo(int[] scale) {
			if (Arrays.equals(scale, ascending)) {
				return ASCENDING_MESSAGE;
			}
			if (Arrays.equals(scale, descending)) {
				return DESCENDING_MESSAGE;
			}
			return MIXED_MESSAGE;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		CMajorScale cMajorScale = new CMajorScale();
		int[] scale = getScale(br);
		String result = cMajorScale.compareTo(scale);
		System.out.println(result);

		br.close();
	}

	private int[] getScale(BufferedReader br) throws IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int size = 8;
		int[] scale = new int[size];
		for (int i = 0; i < size; i++) {
			scale[i] = Integer.parseInt(stk.nextToken());
		}
		return scale;
	}
}
