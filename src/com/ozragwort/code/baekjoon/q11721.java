package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q11721 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int i = 0;
		while (i + 10 < input.length()) {
			bw.write(input.substring(i, i + 10));
			bw.newLine();
			i += 10;
		}
		bw.write(input.substring(i));
		bw.flush();
		bw.close();
		br.close();
	}
}
