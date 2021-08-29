package com.ozragwort.code.programmers.level2;

public class q12980 {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            ans += n % 2;
            n /= 2;
        }

        return ans;
    }
}
