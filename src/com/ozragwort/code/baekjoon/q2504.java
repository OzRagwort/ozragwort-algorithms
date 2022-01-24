package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q2504 {
	static class Score {
		private static final int MAX_SIZE = 30;

		private int[] scores = new int[MAX_SIZE];

		public Score() {
		}

		public int getScore() {
			return scores[0];
		}

		public void increase(int score, int depth) {
			if (scores[depth + 1] == 0) {
				scores[depth] += score;
				return;
			}
			scores[depth] += scores[depth + 1] * score;
			scores[depth + 1] = 0;
		}
	}

	static class Bracket {
		private static final char SMALL_BRACKET_START = '(';
		private static final char SMALL_BRACKET_END = ')';
		private static final char BIG_BRACKET_START = '[';
		private static final char BIG_BRACKET_END = ']';
		private static final int SMALL_BRACKET_SCORE = 2;
		private static final int BIG_BRACKET_SCORE = 3;
		private static final int INVALID_BRACKET_SCORE = 0;

		public Bracket() {
		}

		public int getScore(String input) {
			Stack<Character> stack = new Stack<>();
			Score score = new Score();
			int depth = 0;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (isBracketStart(c)) {
					depth++;
					stack.push(c);
					continue;
				}
				if (stack.isEmpty() || !isBracketPair(stack.pop(), c)) {
					return INVALID_BRACKET_SCORE;
				}
				depth--;
				score.increase(getBracketScore(c), depth);
			}
			return score.getScore();
		}

		private boolean isBracketStart(Character c) {
			return c.equals(SMALL_BRACKET_START) || c.equals(BIG_BRACKET_START);
		}

		private boolean isBracketPair(Character start, Character end) {
			if (start.equals(SMALL_BRACKET_START) && end.equals(SMALL_BRACKET_END)) {
				return true;
			}
			if (start.equals(BIG_BRACKET_START) && end.equals(BIG_BRACKET_END)) {
				return true;
			}
			return false;
		}

		private int getBracketScore(Character c) {
			if (c.equals(SMALL_BRACKET_END)) {
				return SMALL_BRACKET_SCORE;
			}
			if (c.equals(BIG_BRACKET_END)) {
				return BIG_BRACKET_SCORE;
			}
			return 0;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Bracket bracket = new Bracket();
		String input = br.readLine();
		System.out.println(bracket.getScore(input));

		br.close();
	}
}
