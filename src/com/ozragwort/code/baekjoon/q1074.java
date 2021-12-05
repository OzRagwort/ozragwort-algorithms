package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1074 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int length = (int)Math.pow(2, N);

		System.out.println(getCount(length, r, c, 0));
		br.close();
	}

	private int getCount(int length, int r, int c, int count) {
		if (length == 1) {
			return count;
		}
		int halfLength = length / 2;
		int powHalfLength = halfLength * halfLength;
		if (r < halfLength) {
			if (c < halfLength) {
				return getCount(halfLength, r, c, count);
			} else {
				c -= halfLength;
				count += powHalfLength;
				return getCount(halfLength, r, c, count);
			}
		} else {
			if (c < halfLength) {
				r -= halfLength;
				count += powHalfLength * 2;
				return getCount(halfLength, r, c, count);
			} else {
				r -= halfLength;
				c -= halfLength;
				count += powHalfLength * 3;
				return getCount(halfLength, r, c, count);
			}
		}
	}
}
