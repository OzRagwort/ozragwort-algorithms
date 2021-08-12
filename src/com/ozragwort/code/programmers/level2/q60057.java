package com.ozragwort.code.programmers.level2;

public class q60057 {
    public int solution(String s) {
        int minLength = 1;
        int maxLength = s.length() / Math.min(s.length(), 2);
        int min = s.length();

        for (int l = minLength ; l <= maxLength ; l++) {
            StringBuilder sb = new StringBuilder();
            String comp = "";

            int i = 0;
            while (i + l < s.length()) {
                comp = s.substring(i, i + l);

                int count = 1;
                while (true) {
                    int left = i + l * count;
                    int right = left + l;

                    if (right <= s.length() && comp.equals(s.substring(left, right))) {
                        count++;
                    } else {
                        break;
                    }
                }

                String compStr = comp + count;
                if (count == 1) {
                    sb.append(comp);
                } else {
                    sb.append(compStr);
                }
                i += l * count;
            }
            sb.append(s.substring(i));

            if (min > sb.length()) {
                min = sb.length();
            }
        }

        return min;
    }
}
