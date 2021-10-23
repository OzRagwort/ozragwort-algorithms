package com.ozragwort.code.programmers.level1;

public class q12935 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];

        if (arr.length == 1) {
            answer = new int[]{-1};
        } else {
            int minIndex = getMinIndex(arr);
            System.arraycopy(arr, 0, answer, 0, minIndex);
            System.arraycopy(arr, minIndex + 1, answer, minIndex, arr.length - minIndex - 1);
        }

        return answer;
    }

    public int getMinIndex(int[] arr) {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        return index;
    }
}
