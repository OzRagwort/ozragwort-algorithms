package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1080 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		boolean[][] A = new boolean[N][M];
		boolean[][] B = new boolean[N][M];
		readArray(br, A, N, M);
		readArray(br, B, N, M);

		int count = 0;
		for (int n = 0; n <= N - 3; n++) {
			for (int m = 0; m <= M - 3; m++) {
				if (A[n][m] != B[n][m]) {
					transformArray(A, n, m);
					count++;
				}
			}
		}

		if (compareArray(A, B, N, M)) {
			System.out.println(count);
		} else {
			System.out.println("-1");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private boolean[][] readArray(BufferedReader br, boolean[][] arr, int N, int M) throws IOException {
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				if (input.charAt(j) == '1') {
					arr[i][j] = true;
				}
			}
		}

		return arr;
	}

	private boolean[][] transformArray(boolean[][] arr, int n, int m) {
		for (int i = n; i < n + 3; i++) {
			for (int j = m; j < m + 3; j++) {
				arr[i][j] ^= true;
			}
		}
		return arr;
	}

	private boolean compareArray(boolean[][] A, boolean[][] B, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
