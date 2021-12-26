package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1924 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] type = new String[] {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		int startDay = 0;
		int weekDay = 7;

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(stk.nextToken());
		int day = Integer.parseInt(stk.nextToken());

		for (int i = 1; i < month; i++) {
			startDay += days[i - 1];
		}
		startDay += day - 1;
		startDay %= weekDay;

		System.out.println(type[startDay]);

		br.close();
	}
}
