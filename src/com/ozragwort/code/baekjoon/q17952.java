package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q17952 {
	private static final String NO_GIVEN_HOMEWORK = "0";

	static class Homework {
		private int score;
		private int time;

		public Homework(int score, int time) {
			this.score = score;
			this.time = time;
		}

		public void doWork() {
			time--;
		}

		public boolean isFinish() {
			return time == 0;
		}

		public int getScore() {
			return score;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Homework> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int totalScore = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			Homework homework;
			if (stk.nextToken().equals(NO_GIVEN_HOMEWORK)) {
				if (stack.isEmpty()) {
					continue;
				}
				homework = stack.pop();
			} else {
				int score = Integer.parseInt(stk.nextToken());
				int time = Integer.parseInt(stk.nextToken());
				homework = new Homework(score, time);
			}
			homework.doWork();
			if (homework.isFinish()) {
				totalScore += homework.getScore();
				continue;
			}
			stack.push(homework);
		}
		System.out.println(totalScore);

		br.close();
	}
}
