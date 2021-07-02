package com.ozragwort.code.programmers.level2;

public class q42883 {
    int[] num;

    public String solution(String number, int k) {
        num = new int[number.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < number.length() ; i++) {
            num[i] = Integer.parseInt(number.substring(i, i+1));
        }

        for (int i = 0 ; i < number.length() ; i++) {
            if (k + i == number.length()) {
                k--;
            } else {
                if (check(i, k)) {
                    sb.append(number.charAt(i));
                } else {
                    k--;
                }
            }
        }

        return sb.toString();
    }

    public boolean check(int i, int k) {
        for (int j = 1 ; j <= k ; j++) {
            if (num[i] < num[i + j]) {
                return false;
            }
        }
        return true;
    }
}
