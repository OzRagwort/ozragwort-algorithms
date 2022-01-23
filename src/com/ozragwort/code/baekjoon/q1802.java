package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1802 {
	private static final String YES = "YES";
	private static final String NO = "NO";

	static class Origami {
		private static final boolean YES = true;
		private static final boolean NO = false;

		public Origami() {
		}

		public boolean canFold(String method) {
			if (method.length() == 0) {
				return YES;
			}
			int halfLength = method.length() / 2;
			return compareSideBySide(method)
				& canFold(method.substring(0, halfLength))
				& canFold(method.substring(halfLength + 1));
		}

		private boolean compareSideBySide(String method) {
			int lashIndex = method.length() - 1;
			int halfLength = method.length() / 2;
			for (int i = 0; i < halfLength; i++) {
				if (method.charAt(i) == method.charAt(lashIndex - i)) {
					return NO;
				}
			}
			return YES;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Origami origami = new Origami();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String method = br.readLine();
			if (origami.canFold(method)) {
				bw.write(YES + System.lineSeparator());
				continue;
			}
			bw.write(NO + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
