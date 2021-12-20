package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q3273 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());

		List<Integer> numbers = new ArrayList<>();
		while (stk.hasMoreTokens()) {
			numbers.add(Integer.parseInt(stk.nextToken()));
		}
		Collections.sort(numbers);

		int count = 0;
		int left = 0;
		int right = numbers.size() - 1;
		while (left < right) {
			int sum = numbers.get(left) + numbers.get(right);
			if (sum == x) {
				count++;
				left++;
				right--;
				continue;
			}
			if (sum < x) {
				left++;
				continue;
			}
			right--;
		}
		System.out.println(count);
		br.close();
	}
}
