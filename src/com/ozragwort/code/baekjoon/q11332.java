package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class q11332 {
	static class Complexity {
		private static final long CLOCK = 100000000;
		private static final String PASS = "May Pass.";
		private static final String TLE = "TLE!";
		private static final String O_N = "O(N)";
		private static final String O_N_2 = "O(N^2)";
		private static final String O_N_3 = "O(N^3)";
		private static final String O_2_N = "O(2^N)";
		private static final String O_N_FACTORIAL = "O(N!)";

		public Complexity() {
		}

		public String check(String O, int N, int T, int L) {
			if (O.equals(O_N)) {
				return checkON(N, T, L);
			}
			if (O.equals(O_N_2)) {
				return checkON2(N, T, L);
			}
			if (O.equals(O_N_3)) {
				return checkON3(N, T, L);
			}
			if (O.equals(O_2_N)) {
				return checkO2N(N, T, L);
			}
			return checkONFactorial(N, T, L);
		}

		private String checkON(long n, long t, long l) {
			if (l * CLOCK < n * t) {
				return TLE;
			}
			return PASS;
		}

		private String checkON2(long n, long t, long l) {
			BigInteger biNT = new BigInteger(String.valueOf(n))
				.pow(2)
				.multiply(BigInteger.valueOf(t));
			BigInteger biLC = new BigInteger(String.valueOf(l * CLOCK));
			if (biNT.compareTo(biLC) > 0) {
				return TLE;
			}
			return PASS;
		}

		private String checkON3(long n, long t, long l) {
			BigInteger biNT = new BigInteger(String.valueOf(n))
				.pow(3)
				.multiply(BigInteger.valueOf(t));
			BigInteger biLC = new BigInteger(String.valueOf(l * CLOCK));
			if (biNT.compareTo(biLC) > 0) {
				return TLE;
			}
			return PASS;
		}

		private String checkO2N(long n, long t, long l) {
			BigInteger biNT = new BigInteger("2")
				.pow((int)n)
				.multiply(BigInteger.valueOf(t));
			BigInteger biL = new BigInteger(String.valueOf(l * CLOCK));
			if (biNT.compareTo(biL) > 0) {
				return TLE;
			}
			return PASS;
		}

		private String checkONFactorial(long n, long t, long l) {
			BigInteger biNT = new BigInteger(String.valueOf(t));
			BigInteger biL = new BigInteger(String.valueOf(l * CLOCK));
			for (long i = n; i >= 1; i--) {
				biNT = biNT.multiply(BigInteger.valueOf(i));
				if (biNT.compareTo(biL) > 0) {
					return TLE;
				}
			}
			return PASS;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Complexity complexity = new Complexity();
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			String O = stk.nextToken();
			int N = Integer.parseInt(stk.nextToken());
			int T = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			String result = complexity.check(O, N, T, L);
			bw.write(result + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
