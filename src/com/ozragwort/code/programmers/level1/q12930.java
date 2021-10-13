package com.ozragwort.code.programmers.level1;

public class q12930 {
    public String solution(String s) {
        String[] arr = s.split(" ", -1);
        // split에서 limit를 음수로 지정하면 끝까지 다 구분함

        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = transform(arr[i]);
        }

        String answer = String.join(" ", arr);
        return answer;
    }

    public String transform(String s) {
        StringBuilder sb = new StringBuilder();
        boolean even = true;

        for (int i = 0 ; i < s.length() ; i++) {
            if (even) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            even ^= true;
        }

        return sb.toString();
    }
}
