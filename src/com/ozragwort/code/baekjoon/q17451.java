package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q17451 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		pushNumbers(numbers, stk);

		long minSpeed = calcMinSpeed(numbers);
		System.out.println(minSpeed);

		br.close();
	}

	private long calcMinSpeed(int[] numbers) {
		long speed = 0;
		for (int i = numbers.length - 1; i >= 0; i--) {
			if (speed <= numbers[i]) {
				speed = numbers[i];
			} else {
				long weight = (long)Math.ceil((double)speed / numbers[i]);
				speed = numbers[i] * weight;
			}
		}
		return speed;
	}

	private void pushNumbers(int[] numbers, StringTokenizer stk) {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
