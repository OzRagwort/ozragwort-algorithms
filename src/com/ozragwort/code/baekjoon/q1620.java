package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1620 {
	class PokeDex {
		HashMap<String, Integer> mapByName = new HashMap<>();
		HashMap<Integer, String> mapByIndex = new HashMap<>();

		public PokeDex() {
			addPokemon("");
		}

		public void addPokemon(String name) {
			mapByName.put(name, mapByName.size());
			mapByIndex.put(mapByIndex.size(), name);
		}

		private int getIndex(String input) {
			return mapByName.get(input);
		}

		private String getName(int index) {
			return mapByIndex.get(index);
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		PokeDex pokeDex = new PokeDex();
		for (int i = 0; i < N; i++) {
			pokeDex.addPokemon(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (isNumber(input)) {
				int number = Integer.parseInt(input);
				bw.write(pokeDex.getName(number) + System.lineSeparator());
			} else {
				int index = pokeDex.getIndex(input);
				bw.write(index + System.lineSeparator());
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
