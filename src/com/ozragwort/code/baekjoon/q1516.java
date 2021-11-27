package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1516 {

	static class Building {
		private int fullBuildTime;
		private int buildTime;
		private final List<Building> preBuildings;

		public Building() {
			fullBuildTime = 0;
			buildTime = 0;
			preBuildings = new ArrayList<>();
		}

		public int getFullBuildTime() {
			if (fullBuildTime == 0) {
				calcFullBuildTime();
			}
			return fullBuildTime;
		}

		public void setBuildTime(int buildTime) {
			this.buildTime = buildTime;
		}

		public void calcFullBuildTime() {
			int finishPreBuild = 0;
			for (Building preBuilding : preBuildings) {
				finishPreBuild = Math.max(finishPreBuild, preBuilding.getFullBuildTime());
			}
			fullBuildTime = buildTime + finishPreBuild;
		}

		public void addPreBuilding(Building building) {
			this.preBuildings.add(building);
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Building> buildings = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			buildings.add(new Building());
		}

		StringTokenizer stk;
		for (int i = 1; i <= N; i++) {
			Building building = buildings.get(i);
			stk = new StringTokenizer(br.readLine());
			int buildTime = Integer.parseInt(stk.nextToken());
			building.setBuildTime(buildTime);
			setAllPreBuildings(buildings, building, stk);
		}

		for (int i = 1; i <= N; i++) {
			Building building = buildings.get(i);
			building.calcFullBuildTime();
			bw.write(Integer.toString(building.getFullBuildTime()));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private void setAllPreBuildings(List<Building> buildings, Building building, StringTokenizer stk) {
		int preBuildingIndex;
		while ((preBuildingIndex = Integer.parseInt(stk.nextToken())) != -1) {
			Building preBuilding = buildings.get(preBuildingIndex);
			building.addPreBuilding(preBuilding);
		}
	}
}
