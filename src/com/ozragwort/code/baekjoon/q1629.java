package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q1629 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());

		long pow = pow(A, B, C);
		int mod = (int)(pow % C);

		System.out.println(mod);

		bw.flush();
		bw.close();
		br.close();
	}

	private long pow(int a, int b, int c) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 1) {
			return a * pow(a, b - 1, c);
		}
		long half = pow(a, b / 2, c) % c;
		return (half * half) % c;
	}
}
