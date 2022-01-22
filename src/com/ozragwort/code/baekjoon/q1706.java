package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class q1706 {
	static class Dictionary {
		private TreeSet<String> dictionary = new TreeSet<>();

		public Dictionary(String[] table) {
			dictionary.addAll(getWordsByHorizontal(table));
			dictionary.addAll(getWordsByVertical(table));
		}

		private List<String> getWordsByHorizontal(String[] table) {
			String join = String.join("#", table);
			return Arrays.stream(join.split("#+"))
				.filter(s -> s.length() >= 2)
				.collect(Collectors.toList());
		}

		private List<String> getWordsByVertical(String[] table) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < table[0].length(); i++) {
				for (int j = 0; j < table.length; j++) {
					sb.append(table[j].charAt(i));
				}
				sb.append("#");
			}
			String join = sb.toString();
			return Arrays.stream(join.split("#+"))
				.filter(s -> s.length() >= 2)
				.collect(Collectors.toList());
		}

		public String findFirst() {
			return dictionary.first();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		String[] words = new String[R];
		for (int i = 0; i < R; i++) {
			words[i] = br.readLine();
		}
		Dictionary dictionary = new Dictionary(words);
		System.out.println(dictionary.findFirst());

		br.close();
	}
}
