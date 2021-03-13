package com.ozragwort.code.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class q11718 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        String input;
        int a = 0;
        ArrayList arr = new ArrayList();

        while(sc.hasNextLine()) {
            input = sc.nextLine();
            if(input.isEmpty() || arr.size()>100) {
                break;
            }
            arr.add(input);
        }

        while(arr.size()>a) {
            System.out.println(arr.get(a++));
        }
    }
}
