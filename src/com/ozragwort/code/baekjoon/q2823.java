package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2823 {
	static class TownMap {
		private static final int[] DR = new int[] {1, -1, 0, 0};
		private static final int[] DC = new int[] {0, 0, 1, -1};

		private boolean[][] maps;

		public TownMap(int row, int column) {
			maps = new boolean[row + 2][column + 2];
		}

		public void setLoad(int row, int column) {
			maps[row + 1][column + 1] = true;
		}

		public boolean hasCulDeSac() {
			for (int i = 1; i < maps.length - 1; i++) {
				for (int j = 1; j < maps[0].length - 1; j++) {
					if (isLoad(i, j) && isCulDeSac(i, j)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean isLoad(int row, int column) {
			return maps[row][column];
		}

		private boolean isCulDeSac(int row, int column) {
			int connectLoadCount = 0;
			for (int i = 0; i < 4; i++) {
				int r = row + DR[i];
				int c = column + DC[i];
				if (maps[r][c]) {
					connectLoadCount++;
				}
			}
			return connectLoadCount == 1;
		}
	}

	static class InputView {
		public static TownMap inputTownMap() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());

			TownMap townMap = new TownMap(R, C);
			for (int i = 0; i < R; i++) {
				String map = br.readLine();
				for (int j = 0; j < C; j++) {
					if (map.charAt(j) == '.') {
						townMap.setLoad(i, j);
					}
				}
			}

			br.close();
			return townMap;
		}
	}

	static class OutputView {
		private static final int HAS_CUL_DE_SAC = 1;
		private static final int NOT_HAS_CUL_DE_SAC = 0;

		public static void culDeSacMap() {
			System.out.println(HAS_CUL_DE_SAC);
		}

		public static void notCulDeSacMap() {
			System.out.println(NOT_HAS_CUL_DE_SAC);
		}
	}

	public void solution() throws IOException {
		TownMap townMap = InputView.inputTownMap();
		if (townMap.hasCulDeSac()) {
			OutputView.culDeSacMap();
			return;
		}
		OutputView.notCulDeSacMap();
	}
}
