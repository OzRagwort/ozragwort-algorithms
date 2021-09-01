package com.ozragwort.code.programmers.level2;

public class q70129 {
    public int[] solution(String s) {
        int counter = 0;
        int deleteZero = 0;

        while (!s.equals("1")) {
            int origLen = s.length();
            s = s.replaceAll("0", "");
            int transLen = s.length();
            s = Integer.toBinaryString(transLen);

            deleteZero += origLen - transLen;
            counter++;
        }

        int[] answer = {counter, deleteZero};
        return answer;
    }
}
