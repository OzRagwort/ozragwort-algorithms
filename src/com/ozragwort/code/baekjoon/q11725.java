package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q11725 {
	private static final int ROOT = 1;

	static class Node {
		private int name;
		private Node parent;
		private List<Node> children = new ArrayList<>();

		public Node(int name) {
			this.name = name;
		}

		public int getName() {
			return name;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public void addChildren(Node child) {
			children.add(child);
		}
	}

	static class Nodes {
		private List<Node> nodes;

		public Nodes(int count) {
			nodes = new ArrayList<>();
			for (int i = 1; i <= count; i++) {
				nodes.add(new Node(i));
			}
		}

		public Node getParentByName(int name) {
			return nodes.get(name - 1).getParent();
		}

		public void set(int parent, int child) {
			Node parentNode = nodes.get(parent - 1);
			Node childNode = nodes.get(child - 1);
			parentNode.addChildren(childNode);
			childNode.setParent(parentNode);
		}
	}

	static class Tree {
		private List<List<Integer>> tree = new ArrayList<>();

		public Tree(int count) {
			for (int i = 0; i <= count; i++) {
				List<Integer> children = new ArrayList<>();
				tree.add(children);
			}
		}

		public void set(int a, int b) {
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		public Nodes getNodes(int root) {
			Nodes nodes = new Nodes(tree.size() - 1);
			List<List<Integer>> tree = new ArrayList<>(this.tree);
			match(nodes, tree, root);
			return nodes;
		}

		private void match(Nodes nodes, List<List<Integer>> tree, int parent) {
			List<Integer> children = tree.get(parent);
			for (Integer child : children) {
				nodes.set(parent, child);
				tree.get(child).remove((Object)parent);
				match(nodes, tree, child);
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Tree tree = new Tree(N);
		String input;
		while ((input = br.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(input);
			int parent = Integer.parseInt(stk.nextToken());
			int child = Integer.parseInt(stk.nextToken());
			tree.set(parent, child);
		}
		Nodes nodes = tree.getNodes(ROOT);

		for (int i = 2; i <= N; i++) {
			bw.write(nodes.getParentByName(i).getName() + System.lineSeparator());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
