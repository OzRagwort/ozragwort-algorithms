package com.ozragwort.code.programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0,0};
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : operations) {
            StringTokenizer stk = new StringTokenizer(s);
            String oper = stk.nextToken();
            int num = Integer.parseInt(stk.nextToken());

            if (oper.equals("I")) {
                pqAsc.offer(num);
                pqDesc.offer(num);
            } else {
                if (pqAsc.isEmpty()) {
                    continue;
                } else {
                    if (num == 1) {
                        int max = pqDesc.poll();
                        pqAsc.remove(max);
                    } else {
                        int min = pqAsc.poll();
                        pqDesc.remove(min);
                    }
                }
            }
        }

        if (!pqAsc.isEmpty()) {
            answer[0] = pqDesc.poll();
            answer[1] = pqAsc.poll();
        }

        return answer;
    }
}
