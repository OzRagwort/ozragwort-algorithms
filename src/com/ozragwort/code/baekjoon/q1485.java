package com.ozragwort.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class q1485 {
	private static final String IS_SQUARE = "1";
	private static final String IS_NOT_SQUARE = "0";

	static class SquareMaker {
		private static final int VERTEX = 4;

		private List<int[]> numbers;

		public SquareMaker() {
			clear();
		}

		public int getVERTEX() {
			return VERTEX;
		}

		public void addPosition(String vertex) {
			StringTokenizer stk = new StringTokenizer(vertex);
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			numbers.add(new int[] {x, y});
		}

		public boolean isSquare() {
			HashSet<Double> lengths = new HashSet<>();
			for (int i = 0; i < VERTEX; i++) {
				lengths.addAll(getLengths(i));
			}
			return lengths.size() == 3;
		}

		private List<Double> getLengths(int index) {
			int[] position = numbers.get(index);
			List<Double> lengthList = new ArrayList<>();
			for (int i = 0; i < VERTEX; i++) {
				lengthList.add(getLength(position, numbers.get(i)));
			}
			return lengthList;
		}

		private double getLength(int[] a, int[] b) {
			int x = Math.abs(a[0] - b[0]);
			int y = Math.abs(a[1] - b[1]);
			return Math.sqrt(x * x + y * y);
		}

		public void clear() {
			numbers = new ArrayList<>();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		SquareMaker squareMaker = new SquareMaker();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			bw.write(canSquareCheck(squareMaker, br));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private String canSquareCheck(SquareMaker squareMaker, BufferedReader br) throws IOException {
		for (int i = 0; i < squareMaker.getVERTEX(); i++) {
			squareMaker.addPosition(br.readLine());
		}
		if (squareMaker.isSquare()) {
			squareMaker.clear();
			return IS_SQUARE;
		}
		squareMaker.clear();
		return IS_NOT_SQUARE;
	}
}
