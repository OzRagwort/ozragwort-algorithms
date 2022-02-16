package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5585 {

    static class Money {

        private static final int[] coins = new int[]{500, 100, 50, 10, 5, 1};

        private int money;

        public Money() {
            money = 1000;
        }


        public int getChanges(int pay) {
            int money = this.money - pay;
            int count = 0;
            for (int coin : coins) {
                count += money / coin;
                money %= coin;
            }
            return count;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Money money = new Money();
        System.out.println(money.getChanges(Integer.parseInt(br.readLine())));

        br.close();
    }
}
