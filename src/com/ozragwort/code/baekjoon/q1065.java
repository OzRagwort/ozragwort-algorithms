package com.ozragwort.code.baekjoon;

import java.util.*;

public class q1065 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int counter = 0;

        for (int i = 1 ; i <= N ; i++) {
            if (func(i))
                counter++;
        }
        System.out.println(counter);
    }

    public boolean func(int input) {
        if (input >= 100) {
            int a = input / 100;
            int b = (input / 10) % 10;
            int c = input % 10;

            if ((a - b) != (b - c))
                return false;
        }
        return true;
    }

//    더 길어진다면 이걸로도 할 수 있을 듯
//    public boolean func(int input) {
//        if (input >= 100) {
//            int prevNum = input % 10;
//            int nextNum = (input / 10) % 10;
//            input /= 10;
//            int diff = nextNum - prevNum;
//
//            while (input >= 10) {
//                prevNum = input % 10;
//                nextNum = (input / 10) % 10;
//                if (diff != (nextNum - prevNum)) {
//                    return false;
//                }
//                input /= 10;
//            }
//
//        }
//        return true;
//    }
}
