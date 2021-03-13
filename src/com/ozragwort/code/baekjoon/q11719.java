package com.ozragwort.code.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class q11719 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        String input;
        int a = 0, arr_size = 100;
        ArrayList arr = new ArrayList();

        while(sc.hasNext()) {
            input = sc.nextLine();
            if(arr.size()>=arr_size) {
                break;
            }
            arr.add(input);
        }

        while(arr.size()>a) {
            System.out.println(arr.get(a++));
        }
    }
}
