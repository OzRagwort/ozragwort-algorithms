package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q9237 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		List<Integer> trees = new ArrayList<>();
		while (stk.hasMoreTokens()) {
			trees.add(Integer.parseInt(stk.nextToken()));
		}
		trees.sort((o1, o2) -> o2 - o1);

		int max = 0;
		int startDay = 1;
		int plantDay = 1;
		for (int day = 0; day < N; day++) {
			int growDay = startDay + plantDay + trees.get(day) + day;
			max = Math.max(max, growDay);
		}

		System.out.println(max);

		br.close();
	}
}
