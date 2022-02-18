package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1371 {

    static class Alphabet {

        public String findMostAlphabet(String input) {
            int[] count = new int[26];
            String replaceAll = input.replaceAll(" |\n", "");
            for (int i = 0; i < replaceAll.length(); i++) {
                count[replaceAll.charAt(i) - 'a']++;
            }
            int max = Arrays.stream(count).max().getAsInt();
            StringBuilder builder = new StringBuilder();
            for (int i = 0 ; i < 26 ; i++) {
                if (count[i] == max) {
                    builder.append(Character.toString('a' + i));
                }
            }
            return builder.toString();
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Alphabet alphabet = new Alphabet();
        String input = null;
        StringBuilder builder = new StringBuilder();
        while ((input = br.readLine()) != null) {
            builder.append(input);
        }
        System.out.println(alphabet.findMostAlphabet(builder.toString()));

        br.close();
    }
}
