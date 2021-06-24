package com.ozragwort.code.programmers.level2;

public class q12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] s = {"4", "1", "2"};

        while (n > 0) {
            sb.append(s[n % 3]);
            n = (n - 1) / 3;
        }

        String answer = sb.reverse().toString();

        return answer;
    }
}
