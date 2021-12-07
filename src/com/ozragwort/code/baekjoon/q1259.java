package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1259 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String N;

		while (isNotZero(N = br.readLine())) {
			if (isPalindrome(N)) {
				bw.write("yes");
			} else {
				bw.write("no");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private boolean isNotZero(String s) {
		return !s.equals("0");
	}

	private boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
