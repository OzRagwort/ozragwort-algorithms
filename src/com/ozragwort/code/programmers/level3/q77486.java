package com.ozragwort.code.programmers.level3;

import java.util.HashMap;

public class q77486 {
    class Node {
        int profit;
        String name;
        Node referralNode;

        public Node(int profit, String name, Node referralNode) {
            this.profit = profit;
            this.name = name;
            this.referralNode = referralNode;
        }

        public void addProfit(int profit) {
            this.profit += profit;
        }

        public void subProfit(int profit) {
            this.profit -= profit;
        }

        public int getProfit() {
            return profit;
        }

        public String getName() {
            return name;
        }

        public Node getReferralNode() {
            return referralNode;
        }
    }

    final int COST = 100;
    HashMap<String, Node> map = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map.put("-", null);
        for (int i = 0 ; i < enroll.length ; i++) {
            map.put(enroll[i], new Node(0, enroll[i], map.get(referral[i])));
        }

        for (int i = 0 ; i < seller.length ; i++) {
            amountCheck(seller[i], amount[i] * COST);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0 ; i < answer.length ; i++) {
            answer[i] = map.get(enroll[i]).getProfit();
        }
        return answer;
    }

    public void amountCheck(String name, int amount) {
        Node node = map.get(name);
        Node nextNode = map.get(name).getReferralNode();
        int profit = amount;
        int nextProfit = profit / 10;
        node.addProfit(profit - nextProfit);

        if (nextNode != null && nextProfit > 0) {
            amountCheck(nextNode.name, nextProfit);
        }
    }
}
