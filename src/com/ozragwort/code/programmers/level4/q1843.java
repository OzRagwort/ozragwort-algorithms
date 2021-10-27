package com.ozragwort.code.programmers.level4;

import java.util.ArrayList;
import java.util.List;

public class q1843 {
    Integer[][] dpMax;
    Integer[][] dpMin;
    List<Integer> nums = new ArrayList<>();
    List<Integer> oper = new ArrayList<>();

    public int solution(String arr[]) {
        dpMax = new Integer[(arr.length / 2) + 1][(arr.length / 2) + 1];
        dpMin = new Integer[(arr.length / 2) + 1][(arr.length / 2) + 1];

        nums.add(Integer.parseInt(arr[0]));
        oper.add(1);
        for (int i = 2 ; i < arr.length ; i+=2) {
            nums.add(Integer.parseInt(arr[i]));
            oper.add(arr[i - 1].equals("+") ? 1 : -1);
        }

        for (int i = 0 ; i < nums.size() ; i++) {
            dpMax[i][i] = dpMin[i][i] = nums.get(i);
        }

        int answer = max(0, nums.size() - 1);

        return answer;
    }

    public int max(int a, int b) {
        if (dpMax[a][b] == null) {
            int max = Integer.MIN_VALUE;
            int r = 0;
            for (int i = a ; i < b ; i++) {
                if (oper.get(i + 1) == 1) {
                    r = max(a, i) + max(i + 1, b);
                } else {
                    r = max(a, i) - min(i + 1, b);
                }
                if (max < r) {
                    max = r;
                }
            }
            dpMax[a][b] = max;
        }
        return dpMax[a][b];
    }

    public int min(int a, int b) {
        if (dpMin[a][b] == null) {
            int min = Integer.MAX_VALUE;
            int r = 0;
            for (int i = a ; i < b ; i++) {
                if (oper.get(i + 1) == 1) {
                    r = min(a, i) + min(i + 1, b);
                } else {
                    r = min(a, i) - max(i + 1, b);
                }
                if (r < min) {
                    min = r;
                }
            }
            dpMin[a][b] = min;
        }
        return dpMin[a][b];
    }
}
