package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class q77885 {
    public long[] solution(long[] numbers) {
        List<Long> list = new ArrayList<>();
        for (long number : numbers) {
            long result = number;

            int shift = 0;
            while ((number & 1) == 1) {
                number >>= 1;
                shift++;
            }
            long dist = ((long) Math.pow(2, shift) - 1) >> 1;

            result += dist + 1;
            list.add(result);
        }

        return list.stream().mapToLong(Long::longValue).toArray();
    }
}
