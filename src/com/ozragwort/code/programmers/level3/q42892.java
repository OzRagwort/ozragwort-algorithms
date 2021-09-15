package com.ozragwort.code.programmers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class q42892 {
    class Node {
        Node parentNode;
        Node leftNode;
        Node rightNode;
        int[] position;

        public Node() {
            parentNode = null;
            leftNode = null;
            rightNode = null;
            position = new int[2];
        };

        public Node getParentNode() {
            return parentNode;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public int[] getPosition() {
            return position;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public void setPosition(int[] position) {
            this.position = position;
        }
    }

    List<Integer> preorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        Node root = null;

        for (int i = 0 ; i < nodeinfo.length ; i++) {
            nodes[i] = new Node();
            nodes[i].position = nodeinfo[i];
        }

        TreeMap<Node, Integer> treeMap = new TreeMap<>((o1, o2) -> {
            int[] p1 = o1.getPosition();
            int[] p2 = o2.getPosition();

            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            } else {
                return p2[1] - p1[1];
            }
        });

        for (int i = 0 ; i < nodeinfo.length ; i++) {
            treeMap.put(nodes[i], i + 1);
        }

        for (Node node : treeMap.keySet()) {
            if (root == null) {
                root = node;
            } else {
                Node in = root;
                int[] p = node.getPosition();
                while (true) {
                    if (p[0] < in.getPosition()[0]) {
                        Node next = in.getLeftNode();
                        if (next == null) {
                            in.setLeftNode(node);
                            node.setParentNode(in);
                            break;
                        } else {
                            in = next;
                        }
                    } else {
                        Node next = in.getRightNode();
                        if (next == null) {
                            in.setRightNode(node);
                            node.setParentNode(in);
                            break;
                        } else {
                            in = next;
                        }
                    }
                }
            }
        }

        preCheck(treeMap, root);
        postCheck(treeMap, root);

        int[][] answer = new int[2][nodes.length];
        answer[0] = preorder.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postorder.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public void preCheck(TreeMap<Node, Integer> treeMap, Node now) {
        preorder.add(treeMap.get(now));
        Node left = now.getLeftNode();
        Node right = now.getRightNode();
        if (left != null) {
            preCheck(treeMap, left);
        }
        if (right != null) {
            preCheck(treeMap, right);
        }
    }

    public void postCheck(TreeMap<Node, Integer> treeMap, Node now) {
        Node left = now.getLeftNode();
        Node right = now.getRightNode();
        if (left != null) {
            postCheck(treeMap, left);
        }
        if (right != null) {
            postCheck(treeMap, right);
        }
        postorder.add(treeMap.get(now));
    }
}
