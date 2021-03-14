package com.ozragwort.code.baekjoon;

import java.util.*;

public class q4673 {
    List<Integer> list = new ArrayList<Integer>();

    public void solution() {
        List<Integer> allNum = new ArrayList<Integer>();
        for (int i = 1 ; i <= 10000 ; i++) {
            func(i);
            allNum.add(i);
        }

        allNum.removeAll(list);
        for (int ret : allNum) {
            System.out.println(ret);
        }
    }

    public void func(int i) {
        int result = i;
        while(i > 0) {
            result += i % 10;
            i /= 10;
        }
        if (!list.contains(result)) {
            list.add(result);
            if (result <= 10000)
                func(result);
        }
    }
}
