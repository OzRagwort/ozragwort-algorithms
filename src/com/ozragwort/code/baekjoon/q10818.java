package com.ozragwort.code.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class q10818 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];

        for (int i = 0 ; i < N ; i++) {
            int num = sc.nextInt();
            array[i] = num;
        }
        Arrays.sort(array);
        System.out.print(array[0] + " " + array[N - 1]);
    }
}
