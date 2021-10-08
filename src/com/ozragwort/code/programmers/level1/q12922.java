package com.ozragwort.code.programmers.level1;

public class q12922 {
    public String solution(int n) {
        String subak = "수박";
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n / 2 ; i++) {
            sb.append(subak);
        }

        if (n % 2 == 1) {
            sb.append("수");
        }

        String answer = sb.toString();
        return answer;
    }
}
