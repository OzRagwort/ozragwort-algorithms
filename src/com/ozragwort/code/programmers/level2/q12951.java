package com.ozragwort.code.programmers.level2;

public class q12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();
        sb.append(s.substring(0, 1).toUpperCase());

        for (int i = 1 ; i < s.length() ; i++) {
            String c = s.substring(i, i + 1);

            if (s.charAt(i - 1) == ' ') {
                c = c.toUpperCase();
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
