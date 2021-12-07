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

public class q1764 {

	static class Peoples {
		List<String> peoples;

		public Peoples() {
			this.peoples = new ArrayList<>();
		}

		public void addPeople(String people) {
			this.peoples.add(people);
		}

		public void sort() {
			Collections.sort(this.peoples);
		}

		public int getSize() {
			return peoples.size();
		}

		public void print() throws IOException {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (String people : peoples) {
				bw.write(people);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		}

		public boolean hasPeople(String name) {
			return binarySearch(name);
		}

		private boolean binarySearch(String name) {
			int left = 0;
			int right = peoples.size() - 1;
			int mid = (left + right) / 2;

			while (left < right) {
				String people = peoples.get(mid);
				int compare = people.compareTo(name);
				if (compare == 0) {
					return true;
				}
				if (compare > 0) {
					right = mid;
				} else {
					left = mid + 1;
				}
				mid = (left + right) / 2;
			}

			return name.compareTo(peoples.get(mid)) == 0;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		Peoples noHearPeople = new Peoples();
		Peoples noSeeHearPeople = new Peoples();
		setupNoHearPeople(noHearPeople, N, br);
		setupNoSeeHearPeople(noSeeHearPeople, noHearPeople, M, br);

		System.out.println(noSeeHearPeople.getSize());
		noSeeHearPeople.print();

		br.close();
	}

	private void setupNoHearPeople(
		Peoples noHearPeople,
		int N,
		BufferedReader br
	) throws IOException {
		for (int i = 0; i < N; i++) {
			noHearPeople.addPeople(br.readLine());
		}
		noHearPeople.sort();
	}

	private void setupNoSeeHearPeople(
		Peoples noSeeHearPeople,
		Peoples noHearPeople,
		int M,
		BufferedReader br
	) throws IOException {
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (noHearPeople.hasPeople(name)) {
				noSeeHearPeople.addPeople(name);
			}
		}
		noSeeHearPeople.sort();
	}
}
