package com.ozragwort.code.programmers.level2;

import java.util.Arrays;

public class q42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        return prefixCheck(phone_book);
    }

    public boolean prefixCheck(String[] phone_book) {
        int arrayLength = phone_book.length;

        for (int i = 0 ; i < arrayLength - 1 ; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
