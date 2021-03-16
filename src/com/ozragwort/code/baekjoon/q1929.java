package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1929 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] arr = new boolean[N];
        arr[0] = true;

        for (int i = 2 ; i < N ; i++) {
            if (!arr[i-1]) {
                int index = i;
                while(index + i <= N) {
                    index += i;
                    arr[index - 1] = true;
                }
            }
        }

        for (int i = M ; i <= N ; i++) {
            if (!arr[i-1])
                System.out.println(i);
        }
    }
}
