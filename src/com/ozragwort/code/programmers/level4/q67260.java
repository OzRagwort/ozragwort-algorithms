package com.ozragwort.code.programmers.level4;

import java.util.*;

public class q67260 {
    class Node {
        int id;
        Node parent;
        List<Node> child;

        public Node(int id) {
            this.id = id;
            this.parent = null;
            this.child = new ArrayList<>();
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setChild(List<Node> child) {
            this.child = child;
        }

        public void addChild(Node child) {
            this.child.add(child);
        }

        public int getId() {
            return id;
        }

        public Node getParent() {
            return parent;
        }

        public List<Node> getChild() {
            return child;
        }
    }

    Node[] nodes;
    HashSet<Node> visit = new HashSet<>();
    HashMap<Integer, Integer> possibleMap = new HashMap<>();
    boolean[] possible;
    boolean[] impossible;
    Queue<Node> queue = new LinkedList<>();

    public boolean solution(int n, int[][] path, int[][] order) {
        nodes = new Node[n];
        possible = new boolean[n];
        impossible = new boolean[n];

        for (int i = 0 ; i < n ; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] p : path) {
            nodes[p[0]].addChild(nodes[p[1]]);
            nodes[p[1]].addChild(nodes[p[0]]);
        }
        setParent(nodes[0], nodes[0]);

        for (int[] o : order) {
            possibleMap.put(o[0], o[1]);
            possible[o[0]] = true;
            impossible[o[1]] = true;
        }

        queue.offer(nodes[0]);
        while (!queue.isEmpty()) {
            search(queue.poll());
        }

        boolean answer = false;
        if (visit.size() == n) {
            answer = true;
        }
        return answer;
    }

    public void search(Node node) {
        List<Node> list = node.getChild();

        if (possible[node.id]) {
            int impossibleId = possibleMap.get(node.id);
            possibleMap.remove(node.id);
            Node pNode = nodes[impossibleId];
            possible[impossibleId] = false;
            impossible[impossibleId] = false;
            if (visit.contains(pNode.getParent())) {
                queue.offer(pNode);
            }
        }

        if (!impossible[node.id] && !visit.contains(node)) {
            visit.add(node);
            for (Node next : list) {
                search(next);
            }
        }
    }

    public void setParent(Node node, Node parent) {
        node.setParent(parent);
        node.getChild().remove(parent);

        List<Node> list = node.getChild();

        for (Node next : list) {
            setParent(next, node);
        }
    }
}
