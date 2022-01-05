package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/status/10546/1002/1
public class q10546 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String init = "                    ";
		byte[] bytes = init.getBytes();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			xor(bytes, br.readLine());
		}

		for (int i = 0; i < N - 1; i++) {
			xor(bytes, br.readLine());
		}

		xor(bytes, init);
		String result = getName(bytes);
		System.out.println(result);

		br.close();
	}

	private void xor(byte[] bytes, String input) {
		byte[] inputBytes = input.getBytes();
		int length = Math.min(bytes.length, inputBytes.length);
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte)(bytes[i] ^ inputBytes[i]);
		}
	}

	private String getName(byte[] bytes) {
		String name = new String(bytes);
		return name.trim();
	}
}
