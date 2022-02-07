package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q11724 {
	static class Node {
		private int name;
		private List<Node> connect = new ArrayList<>();

		public Node(int name) {
			this.name = name;
		}

		public int getName() {
			return name;
		}

		public List<Node> getConnect() {
			return connect;
		}

		public void add(Node node) {
			connect.add(node);
		}
	}

	static class Nodes {
		public List<Node> nodes = new ArrayList<>();

		public Nodes(int count) {
			for (int i = 0; i <= count; i++) {
				nodes.add(new Node(i));
			}
		}

		public void connect(int a, int b) {
			Node A = nodes.get(a);
			Node B = nodes.get(b);
			A.add(B);
			B.add(A);
		}

		public int getCountOfElement() {
			int count = 0;
			boolean[] visit = new boolean[nodes.size()];
			for (int i = 1; i < nodes.size(); i++) {
				if (visit[i]) {
					continue;
				}
				count++;
				visit[i] = true;
				search(visit, i);
			}

			return count;
		}

		private void search(boolean[] visit, int index) {
			List<Node> connect = nodes.get(index).getConnect();
			for (Node node : connect) {
				int name = node.getName();
				if (visit[name]) {
					continue;
				}
				visit[name] = true;
				search(visit, name);
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		Nodes nodes = new Nodes(N);
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			nodes.connect(a, b);
		}
		System.out.println(nodes.getCountOfElement());

		br.close();
	}
}
