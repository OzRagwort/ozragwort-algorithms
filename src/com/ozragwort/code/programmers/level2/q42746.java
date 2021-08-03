package com.ozragwort.code.programmers.level2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class q42746 {
    public String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();

        for (int number : numbers) {
            numberList.add(Integer.toString(number));
        }

        numberList.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));

        StringBuilder sb = new StringBuilder();

        for (String number : numberList) {
            sb.append(number);
        }

        BigInteger bigInteger = new BigInteger(sb.toString());

        return bigInteger.toString();
    }
}
