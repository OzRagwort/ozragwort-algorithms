package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1497 {

    int N, M;
    long[] guitar;
    long maxSong = 0;
    int min = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa;
        sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        guitar = new long[N];

        for (int i = 0 ; i < N ; i++) {
            sa = br.readLine().split(" ");
            for (int j = 0 ; j < M ; j++) {
                guitar[i] <<= 1;
                guitar[i] += sa[1].charAt(j) == 'Y' ? 1 : 0;
            }
        }

        buyGuitar(0, 0, 0);

        if (maxSong == 0) {
            System.out.print("-1");
        } else {
            System.out.print(min);
        }
    }

    public void buyGuitar(long n, int guitarCount, int index) {
        int bit = Long.bitCount(n | guitar[index]);

        if (maxSong < bit) {
            maxSong = bit;
            min = guitarCount + 1;
        } else if (maxSong == bit) {
            min = Math.min(min, guitarCount + 1);
        }

        if (index + 1 < N) {
            buyGuitar(n, guitarCount, index + 1);
            buyGuitar(n | guitar[index], guitarCount + 1, index + 1);
        }
    }
}
