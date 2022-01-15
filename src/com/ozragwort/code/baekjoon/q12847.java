package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12847 {
	static class WagesCalculator {
		private int[] wages;

		public WagesCalculator(int n) {
			wages = new int[n];
		}

		public void set(int i, int wages) {
			this.wages[i] = wages;
		}

		public long getMaxWages(int m) {
			long nowWages = 0;
			for (int i = 0 ; i < m ; i++) {
				nowWages += wages[i];
			}

			long max = nowWages;
			for (int i = m ; i < wages.length ; i++) {
				nowWages = nowWages + wages[i] - wages[i - m];
				max = Math.max(max, nowWages);
			}

			return max;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		WagesCalculator wagesCalculator = new WagesCalculator(n);
		stk = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			wagesCalculator.set(i, Integer.parseInt(stk.nextToken()));
		}
		System.out.println(wagesCalculator.getMaxWages(m));

		br.close();
	}
}
