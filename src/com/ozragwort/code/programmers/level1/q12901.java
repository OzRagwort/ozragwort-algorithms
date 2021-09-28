package com.ozragwort.code.programmers.level1;

public class q12901 {
    public String solution(int a, int b) {
        int[] days = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int count = 0;

        for (int i = 0 ; i < a - 1 ; i++) {
            count += days[i];
        }
        count += b;

        String answer = day[count % 7];
        return answer;
    }
}
