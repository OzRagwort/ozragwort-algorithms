package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class q3052 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> modSet = new HashSet<>();
		int MOD = 42;
		int count = 10;

		for (int i = 0; i < count; i++) {
			int number = Integer.parseInt(br.readLine());
			modSet.add(number % MOD);
		}

		System.out.println(modSet.size());
		br.close();
	}
}
