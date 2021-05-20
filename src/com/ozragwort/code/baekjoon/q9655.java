package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class q9655 {
    public void solution() throws IOException {
        // 84ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(br.readLine()) % 2 == 0 ? "CY" : "SK");

        // 116ms
        Scanner sc = new Scanner(System.in);
        System.out.print(sc.nextInt() % 2 == 0 ? "CY" : "SK");
    }
}
