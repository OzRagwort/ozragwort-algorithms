package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q2012 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(numbers);

		int index = 1;
		long dissatisfaction = 0;
		for (Integer number : numbers) {
			dissatisfaction += Math.abs(index - number);
			index++;
		}
		System.out.println(dissatisfaction);
		br.close();
	}
}
