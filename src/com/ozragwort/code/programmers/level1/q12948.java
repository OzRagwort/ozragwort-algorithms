package com.ozragwort.code.programmers.level1;

public class q12948 {
    public String solution(String phone_number) {
        String answer = "********************".substring(0, phone_number.length() - 4) + phone_number.substring(phone_number.length() - 4);
        return answer;
    }
}
