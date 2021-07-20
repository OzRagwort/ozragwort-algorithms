package com.ozragwort.code.programmers.level3;

public class q12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w + w + 1;
        int start = 0;

        for (int station : stations) {
            int end = station - w - 1;
            if (start < end) {
                answer += (end - start - 1) / range + 1;
            }
            start = station + w;
        }
        if (start < n) {
            answer += (n - start - 1) / range + 1;
        }

        return answer;
    }
}
