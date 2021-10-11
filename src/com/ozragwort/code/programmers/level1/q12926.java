package com.ozragwort.code.programmers.level1;

public class q12926 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                c = shiftCharacter(c, n);
            }
            sb.append(c);
        }

        String answer = sb.toString();
        return answer;
    }

    public char shiftCharacter(char c, int n) {
        int a = 'a';
        int b = 'z';

        if ('A' <= c && c <= 'Z') {
            a = 'A';
            b = 'Z';
        }

        c += n;
        if (!(a <= c && c <= b)) {
            c -= 26;
        }

        return c;
    }
}
