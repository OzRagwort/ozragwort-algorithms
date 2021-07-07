package com.ozragwort.code.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class q42884 {
    public int solution(int[][] routes) {
        int counter = 0;
        int camera = Integer.MIN_VALUE;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        for (int[] route : routes) {
            if (camera < route[0]) {
                counter++;
                camera = route[1];
            }
        }

        return counter;
    }
}
