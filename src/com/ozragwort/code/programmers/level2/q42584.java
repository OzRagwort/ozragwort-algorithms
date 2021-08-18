package com.ozragwort.code.programmers.level2;

import java.util.Stack;

public class q42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> price = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for (int i = 0 ; i < prices.length ; i++) {
            while (!price.isEmpty() && price.peek() > prices[i]) {
                price.pop();
                int idx = index.pop();
                answer[idx] = i - idx;
            }
            price.push(prices[i]);
            index.push(i);
        }

        while (!price.isEmpty()) {
            price.pop();
            int idx = index.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }
}
