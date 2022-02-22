package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class q5543 {

    static class SetMenu {

        public int getPrice(List<Integer> burger, List<Integer> beverage) {
            int burgerMin = burger.stream()
                    .min(Comparator.comparingInt(o -> o))
                    .get();
            int beverageMin = beverage.stream()
                    .min(Comparator.comparingInt(o -> o))
                    .get();
            return burgerMin + beverageMin - 50;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> burger = new ArrayList<>(Arrays.asList(
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine())
        ));
        List<Integer> beverage = new ArrayList<>(Arrays.asList(
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine())
        ));
        SetMenu setMenu = new SetMenu();
        System.out.println(setMenu.getPrice(burger, beverage));

        br.close();
    }
}
