package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16953 {
	static class Number {
		private long number;
		private int count;
		private long targetNumber;

		public Number(long number, int targetNumber) {
			this.number = number;
			this.count = 1;
			this.targetNumber = targetNumber;
		}

		public Number(Number number) {
			this.number = number.number;
			this.count = number.count;
			this.targetNumber = number.targetNumber;
		}

		public int getCount() {
			return count;
		}

		public void mulTwo() {
			number *= 2;
			count++;
		}

		public void attackRightOne() {
			number = (number * 10) + 1;
			count++;
		}

		public boolean isSameNumber(int number) {
			return this.number == number;
		}

		public boolean isOverRange() {
			return number > targetNumber;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());

		Queue<Number> numbers = new LinkedList<>();
		numbers.add(new Number(A, B));

		int count = -1;
		while (!numbers.isEmpty()) {
			Number number = numbers.poll();
			if (number.isSameNumber(B)) {
				count = number.getCount();
				break;
			}
			checkMulTwo(numbers, number);
			checkAttackRightOne(numbers, number);
		}
		System.out.println(count);

		br.close();
	}

	private void checkMulTwo(Queue<Number> numbers, Number number) {
		Number mulTwoNumber = new Number(number);
		mulTwoNumber.mulTwo();
		if (mulTwoNumber.isOverRange()) {
			return;
		}
		numbers.offer(mulTwoNumber);
	}

	private void checkAttackRightOne(Queue<Number> numbers, Number number) {
		Number attackRightOneNumber = new Number(number);
		attackRightOneNumber.attackRightOne();
		if (attackRightOneNumber.isOverRange()) {
			return;
		}
		numbers.offer(attackRightOneNumber);
	}
}
