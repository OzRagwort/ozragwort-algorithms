package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class q2304 {
	static class Pillar {
		private int l;
		private int h;

		public Pillar(int l, int h) {
			this.l = l;
			this.h = h;
		}

		public int compareHeightTo(Pillar pillar) {
			return this.h - pillar.h;
		}
	}

	static class Pillars {
		private List<Pillar> pillars;

		public Pillars(TreeSet<Pillar> pillars) {
			this.pillars = new ArrayList<>(pillars);
		}

		public int maxHeight() {
			return pillars.stream()
				.max(Comparator.comparingInt(o -> o.h))
				.get()
				.h;
		}

		public Pillar get(int i) {
			return pillars.get(i);
		}

		public int getSize() {
			return pillars.size();
		}

		public int heightIndexOf(int maxHeight) {
			for (int i = 0; i < pillars.size(); i++) {
				if (pillars.get(i).h == maxHeight) {
					return i;
				}
			}
			return 0;
		}

		public int heightLastIndexOf(int maxHeight) {
			for (int i = pillars.size() - 1; i > 0; i--) {
				if (pillars.get(i).h == maxHeight) {
					return i;
				}
			}
			return 0;
		}
	}

	static class Storage {
		private TreeSet<Pillar> pillars;

		public Storage() {
			pillars = new TreeSet<>(Comparator.comparingInt(o -> o.l));
		}

		public void add(int l, int h) {
			pillars.add(new Pillar(l, h));
		}

		public int getArea() {
			Pillars pillars = new Pillars(this.pillars);
			int maxHeight = pillars.maxHeight();
			int maxHeightFirstIndex = pillars.heightIndexOf(maxHeight);
			int maxHeightLastIndex = pillars.heightLastIndexOf(maxHeight);

			int area = maxHeight * (pillars.get(maxHeightLastIndex).l - pillars.get(maxHeightFirstIndex).l + 1);
			area += getAreaBeforeMaxHeight(pillars, maxHeightFirstIndex);
			area += getAreaAfterMaxHeight(pillars, maxHeightLastIndex);
			return area;
		}

		private int getAreaBeforeMaxHeight(Pillars pillars, int maxHeightPillarIndex) {
			int area = 0;
			Pillar standard = pillars.get(0);
			for (int i = 1; i <= maxHeightPillarIndex; i++) {
				Pillar pillar = pillars.get(i);
				if (standard.compareHeightTo(pillar) < 0) {
					area += standard.h * (pillar.l - standard.l);
					standard = pillar;
				}
			}
			return area;
		}

		private int getAreaAfterMaxHeight(Pillars pillars, int maxHeightPillarIndex) {
			int area = 0;
			int size = pillars.getSize();
			Pillar standard = pillars.get(size - 1);
			for (int i = size - 2; i >= maxHeightPillarIndex; i--) {
				Pillar pillar = pillars.get(i);
				if (standard.compareHeightTo(pillar) < 0) {
					area += standard.h * (standard.l - pillar.l);
					standard = pillar;
				}
			}
			return area;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Storage storage = new Storage();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(stk.nextToken());
			int H = Integer.parseInt(stk.nextToken());
			storage.add(L, H);
		}

		int area = storage.getArea();
		System.out.println(area);

		br.close();
	}
}
