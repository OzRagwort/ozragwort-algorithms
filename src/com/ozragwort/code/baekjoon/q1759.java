package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q1759 {
	static List<String> vowels = new ArrayList<String>() {{
		add("a");
		add("e");
		add("i");
		add("o");
		add("u");
	}};

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<>();
		while (stk.hasMoreTokens()) {
			list.add(stk.nextToken());
		}
		Collections.sort(list);

		List<String> passwords = new ArrayList<>();
		calcPasswords(passwords, list, L, C, 0, 0, "");

		for (String password : passwords) {
			bw.write(password);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private void calcPasswords(
		List<String> passwords,
		List<String> list,
		int l,
		int c,
		int depth,
		int start,
		String password
	) {
		if (depth == l) {
			if (check(password)) {
				passwords.add(password);
			}
			return;
		}
		for (int i = start; i < c; i++) {
			calcPasswords(passwords, list, l, c, depth + 1, i + 1, password + list.get(i));
		}
	}

	private boolean check(String password) {
		int vowelsCount = 0;
		int consonantsCount = 0;
		for (int i = 0; i < password.length(); i++) {
			String s = Character.toString(password.charAt(i));
			if (vowels.contains(s)) {
				vowelsCount++;
			} else {
				consonantsCount++;
			}
		}
		return vowelsCount >= 1 && consonantsCount >= 2;
	}
}
