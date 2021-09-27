package com.ozragwort.code.programmers.level1;

public class q17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0 ; i < n ; i++) {
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            answer[i] = binaryString
                    .replaceAll("1", "#")
                    .replaceAll("0", " ");
        }

        return answer;
    }
}
