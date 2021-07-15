package com.ozragwort.code.programmers.level3;

import java.util.Arrays;
import java.util.HashMap;

public class q70130 {
    public int solution(int[] a) {
        if (a.length < 2) {
            return 0;
        } else {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0 ; i < a.length ; i++) {
                if (map.containsKey(a[i])) {
                    map.put(a[i], map.get(a[i]) + 1);
                } else {
                    map.put(a[i], 1);
                }
            }

            Integer[] array = map.keySet().toArray(new Integer[map.size()]);
            Arrays.sort(array, (o1, o2) -> map.get(o2) - map.get(o1));

            int max = 0;

            for (int n : array) {
                if (max <= map.get(n) * 2) {
                    max = Math.max(max, check(a, n));
                } else {
                    break;
                }
            }

            return max;
        }
    }

    public int check(int[] a, int n) {
        int counter = 0;
        int i = 0;

        while (i + 1 < a.length) {
            if (a[i] != a[i + 1] && (a[i] == n || a[i + 1] == n)) {
                counter += 2;
                i+= 2;
            } else {
                i++;
            }
        }

        return counter;
    }
}
