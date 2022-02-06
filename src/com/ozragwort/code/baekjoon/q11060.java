package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11060 {
	static class State {
		private int position;
		private int count;

		public State(int position, int count) {
			this.position = position;
			this.count = count;
		}

		public int getPosition() {
			return position;
		}

		public int getCount() {
			return count;
		}

		public boolean isPosition(int position) {
			return this.position == position;
		}
	}

	static class Jump {
		private int[] table;

		public Jump(int[] table) {
			this.table = table;
		}

		public int getMinNumberOfPath() {
			Queue<State> queue = new LinkedList<>();
			queue.add(new State(0, 0));
			int[] dp = new int[table.length];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;

			int min = -1;
			while (!queue.isEmpty()) {
				State state = queue.poll();
				int position = state.getPosition();
				int count = state.getCount();
				if (dp[position] < count) {
					continue;
				}
				dp[position] = count;
				if (state.isPosition(table.length - 1)) {
					min = count;
					break;
				}
				for (int i = 1; i <= table[position]; i++) {
					if (position + i < table.length && dp[position] + 1 < dp[position + i]) {
						dp[position + i] = dp[position] + 1;
						queue.add(new State(position + i, dp[position] + 1));
					}
				}
			}
			return min;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] table = new int[N];

		for (int i = 0; i < N; i++) {
			table[i] = Integer.parseInt(stk.nextToken());
		}
		Jump jump = new Jump(table);
		System.out.println(jump.getMinNumberOfPath());

		br.close();
	}
}
