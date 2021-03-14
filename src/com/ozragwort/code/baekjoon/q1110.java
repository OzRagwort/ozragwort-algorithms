package com.ozragwort.code.baekjoon;

import java.util.Scanner;

public class q1110 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int counter = 0;

        int originNum = sc.nextInt();
        int num = originNum;

        do {
            num = (num % 10) * 10 + ((num / 10) + (num % 10)) % 10;
            counter++;
        } while(originNum != num);

        System.out.println(counter);
    }
}
