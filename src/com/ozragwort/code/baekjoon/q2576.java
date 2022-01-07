package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2576 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = 7;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n % 2 == 1) {
				sum += n;
				min = Math.min(min, n);
			}
		}

		if (sum == 0) {
			bw.write("-1");
		} else {
			bw.write(Integer.toString(sum));
			bw.newLine();
			bw.write(Integer.toString(min));
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
