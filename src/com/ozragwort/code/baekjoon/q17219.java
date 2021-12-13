package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q17219 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			String key = stk.nextToken();
			String value = stk.nextToken();
			map.put(key, value);
		}

		for (int i = 0; i < M; i++) {
			bw.write(map.get(br.readLine()) + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
