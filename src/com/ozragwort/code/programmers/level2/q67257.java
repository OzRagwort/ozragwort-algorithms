package com.ozragwort.code.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class q67257 {
    public long solution(String expression) {
        long answer = 0;

        List<Long> nums = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        List<String> operatorSet = new ArrayList<>();

        Long[] numArray = Arrays.stream(expression
                .split("[^0-9]"))
                .map(Long::parseLong)
                .toArray(Long[]::new);
        nums = new ArrayList<>(Arrays.asList(numArray));
        operator = new ArrayList<>(Arrays.asList(expression.split("[0-9]+")));
        operator.remove("");
        operatorSet = new ArrayList<>(new HashSet<>(operator));

        List<List<Integer>> operatorCombinations = getCombination(new ArrayList<>(), new ArrayList<>(), operatorSet.size(), 0);

        for (List<Integer> combination : operatorCombinations) {
            long result = calc(new ArrayList<>(nums), new ArrayList<>(operator), operatorSet, combination);
            if (answer < result) {
                answer = result;
            }
        }

        return answer;
    }

    public long calc(List<Long> nums, List<String> operator, List<String> operatorSet, List<Integer> combination) {
        for (Integer operIndex : combination) {
            String o = operatorSet.get(operIndex);

            while (operator.indexOf(o) >= 0) {
                int i = operator.indexOf(o);
                if (o.equals("+")) {
                    nums.set(i, nums.get(i) + nums.get(i + 1));
                } else if (o.equals("-")) {
                    nums.set(i, nums.get(i) - nums.get(i + 1));
                } else {
                    nums.set(i, nums.get(i) * nums.get(i + 1));
                }

                nums.remove(i + 1);
                operator.remove(i);
            }
        }

        return Math.abs(nums.get(0));
    }

    public List<List<Integer>> getCombination(List<List<Integer>> comb, List<Integer> list, int size, int depth) {
        if (depth == size) {
            comb.add(new ArrayList<>(list));
        } else {
            for (int i = 0 ; i < size ; i++) {
                if (list.contains(i)) {
                    continue;
                } else {
                    list.add(i);
                    comb = getCombination(comb, list, size, depth + 1);
                    list.remove((Integer) i);
                }
            }
        }
        return comb;
    }
}
