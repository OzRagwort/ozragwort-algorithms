package com.ozragwort.code.programmers.level1;

public class q12940 {
    public int[] solution(int n, int m) {
        int gcd = GCD(Math.max(n, m), Math.min(n, m));
        int[] answer = new int[]{gcd, n * m / gcd};
        return answer;
    }

    public int GCD(int n, int m) {
        if (m != 0) {
            return GCD(m, n % m);
        } else {
            return n;
        }
    }
}
