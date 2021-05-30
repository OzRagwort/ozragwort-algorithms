package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1784 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] dp = new String[S.length()];

        dp[0] = String.valueOf(S.charAt(0));
        for (int i = 1 ; i < S.length() ; i++) {
            for (int j = 0 ; j < i ; j++) {
                String p = palindrome(dp[j] + S.substring(j + 1, i + 1));
                if (dp[i] == null || dp[i].length() > p.length()) {
                    dp[i] = p;
                }
            }
        }

        System.out.print(dp[S.length() - 1].length());
    }

    public String palindrome(String s) {
        int l = 0;
        int end = s.length() - 1;

        for (int start = end - 1 ; start >= 0 ; start-=2) {
            if (s.charAt(start) == s.charAt(end)) {
                if (check(s, start, end)) {
                    l = end - start + 1;
                }
            }
        }

        if (l == 0) {
            return s;
        } else {
            return palindrome(s.substring(0, (end + 1) - (l / 2)));
        }
    }

    public boolean check(String s, int start, int end) {
        boolean check = true;

        for (int i = 0 ; i < (end - start + 1) / 2 ; i++) {
            if (s.charAt(end - i) != s.charAt(start + i)) {
                check = false;
                break;
            }
        }

        return check;
    }
}
