package com.ozragwort.code.programmers.level1;

public class q67256 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String h = hand.equals("right") ? "R" : "L";

        int right = 10;
        int left = 12;
        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            } else if (number % 3 == 1) {
                sb.append("L");
                left = number;
                continue;
            } else if (number % 3 == 0) {
                sb.append("R");
                right = number;
                continue;
            }

            int rightDist = getDist(number, right);
            int leftDist = getDist(number, left);

            if (rightDist < leftDist) {
                sb.append("R");
                right = number;
            } else if (leftDist < rightDist) {
                sb.append("L");
                left = number;
            } else {
                sb.append(h);
                if (h.equals("R")) {
                    right = number;
                } else {
                    left = number;
                }
            }
        }


        return sb.toString();
    }

    public int getDist(int a, int b) {
        return Math.abs(((a - 1) % 3 + 1) - ((b - 1) % 3 + 1)) + Math.abs((a - 1) / 3 - (b - 1) / 3);
    }
}
