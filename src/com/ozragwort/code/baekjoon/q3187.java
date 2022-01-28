package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3187 {
	static class Animals {
		public static final String BLANK = ".";
		public static final String WALL = "#";
		public static final String WOLF = "v";
		public static final String SHEEP = "k";
	}

	static class FarmMap {
		private static final int[] DR = new int[] {1, -1, 0, 0};
		private static final int[] DC = new int[] {0, 0, 1, -1};

		private String[][] maps;

		public FarmMap(int row, int column) {
			maps = new String[row][column];
		}

		public void set(int r, int c, String s) {
			maps[r][c] = s;
		}

		public AnimalCount getAnimalCount() {
			int r = maps.length;
			int c = maps[0].length;
			boolean[][] visit = new boolean[r][c];

			AnimalCount animalCount = new AnimalCount();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (isVisitorWall(i, j, visit)) {
						continue;
					}
					animalCount.addMore(search(i, j, visit));
				}
			}
			return animalCount;
		}

		private boolean isVisitorWall(int r, int c, boolean[][] visit) {
			if (visit[r][c]) {
				return true;
			}
			if (maps[r][c].equals(Animals.WALL)) {
				visit[r][c] = true;
				return true;
			}
			return false;
		}

		private AnimalCount search(int r, int c, boolean[][] visit) {
			AnimalCount count = new AnimalCount();
			visit[r][c] = true;
			count.add(maps[r][c]);

			for (int i = 0; i < 4; i++) {
				int tr = r + DR[i];
				int tc = c + DC[i];
				if (0 <= tr && tr < maps.length && 0 <= tc && tc < maps[0].length) {
					if (visit[tr][tc] || maps[tr][tc].equals(Animals.WALL)) {
						continue;
					}
					count.addAll(search(tr, tc, visit));
				}
			}
			return count;
		}
	}

	static class AnimalCount {
		private int wolf;
		private int sheep;

		public AnimalCount() {
			this.wolf = 0;
			this.sheep = 0;
		}

		public int getWolf() {
			return wolf;
		}

		public int getSheep() {
			return sheep;
		}

		public void add(String s) {
			if (s.equals(Animals.SHEEP)) {
				sheep++;
			}
			if (s.equals(Animals.WOLF)) {
				wolf++;
			}
		}

		public void addAll(AnimalCount count) {
			wolf += count.getWolf();
			sheep += count.getSheep();
		}

		public void addMore(AnimalCount count) {
			if (count.getSheep() > count.getWolf()) {
				sheep += count.getSheep();
				return;
			}
			wolf += count.getWolf();
		}
	}

	static class InputView {
		public static FarmMap inputFarmMap() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());

			FarmMap farmMap = new FarmMap(R, C);
			for (int i = 0; i < R; i++) {
				String map = br.readLine();
				for (int j = 0; j < C; j++) {
					farmMap.set(i, j, Character.toString(map.charAt(j)));
				}
			}

			br.close();
			return farmMap;
		}
	}

	static class OutputView {
		public static void outputAnimalCount(AnimalCount animalCount) {
			System.out.println(animalCount.getSheep() + " " + animalCount.getWolf());
		}
	}

	public void solution() throws IOException {
		FarmMap farmMap = InputView.inputFarmMap();
		OutputView.outputAnimalCount(farmMap.getAnimalCount());
	}
}
