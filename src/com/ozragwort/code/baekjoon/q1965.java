package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1965 {
	static class Box {
		private int[] boxSize;

		public Box(int[] boxSize) {
			this.boxSize = boxSize;
		}

		public int getMaxPutBoxes() {
			return Arrays.stream(getPutBoxes())
				.max()
				.getAsInt();
		}

		private int[] getPutBoxes() {
			int[] count = new int[boxSize.length];
			Arrays.fill(count, 1);
			for (int i = 0; i < boxSize.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (boxSize[j] < boxSize[i]) {
						count[i] = Math.max(count[i], count[j] + 1);
					}
				}
			}
			return count;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] boxSize = new int[n];
		for (int i = 0 ; i < n ; i++) {
			boxSize[i] = Integer.parseInt(stk.nextToken());
		}
		Box box = new Box(boxSize);
		System.out.println(box.getMaxPutBoxes());

		br.close();
	}
}
