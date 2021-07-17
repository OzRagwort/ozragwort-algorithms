package com.ozragwort.code.programmers.level3;

public class q12904 {
    public int solution(String s) {
        int max = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = 0 ; j <= i ; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int length = check(s, i, j);
                    if (max < length) {
                        max = length;
                        break;
                    }
                }
            }
        }

        return max;
    }

    public int check(String s, int i, int j) {
        int length = i - j + 1;
        while (j <= i) {
            if (s.charAt(j) != s.charAt(i)) {
                return 0;
            }
            j++;
            i--;
        }
        return length;
    }
}
