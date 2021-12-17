package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q10825 {
	class People {
		private String name;
		private int korean;
		private int english;
		private int math;

		public People(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		public String getName() {
			return name;
		}

		public int compareTo(People people) {
			if (korean != people.korean) {
				return people.korean - korean;
			}
			if (english != people.english) {
				return english - people.english;
			}
			if (math != people.math) {
				return people.math - math;
			}
			return name.compareTo(people.name);
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<People> peopleList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			People people = new People(
				stk.nextToken(),
				Integer.parseInt(stk.nextToken()),
				Integer.parseInt(stk.nextToken()),
				Integer.parseInt(stk.nextToken())
			);
			peopleList.add(people);
		}

		peopleList.sort(People::compareTo);
		for (People people : peopleList) {
			bw.write(people.getName());
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
