package com.ozragwort.code.programmers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class q12946 {
    Stack<Integer>[] stack = new Stack[3];
    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        stack[2] = new Stack<>();
        for (int i = n ; i > 0 ; i--) {
            stack[0].push(i);
        }

        move(0, 2, 1, n);

        int[][] answer = list.toArray(new int[0][0]);
        return answer;
    }

    public void move(int start, int end, int buffer, int n) {
        if (n == 1) {
            stack[end].push(stack[start].pop());
            list.add(new int[]{start + 1, end + 1});
        } else {
            move(start, buffer, end, n - 1);
            stack[end].push(stack[start].pop());
            list.add(new int[]{start + 1, end + 1});
            move(buffer, end, start, n - 1);
        }
    }
}
