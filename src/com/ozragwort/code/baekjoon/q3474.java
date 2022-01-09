package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q3474 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int countByRightZero = getCountByRightZero(N);
			bw.write(countByRightZero + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private int getCountByRightZero(int n) {
		int count2 = 0;
		int count5 = 0;
		for (int i = 2; i <= n; i *= 2) {
			count2 += n / i;
		}
		for (int i = 5; i <= n; i *= 5) {
			count5 += n / i;
		}
		return Math.min(count2, count5);
	}
}
