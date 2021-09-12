package com.ozragwort.code.programmers.level2;

public class q60058 {
    public String solution(String p) {
        return transform(p);
    }

    public String transform(String s) {
        if (s.length() == 0) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder();
            int firstBalanceIndex = firstBalanceIndex(s);
            String u = s.substring(0, firstBalanceIndex);
            String v = s.substring(firstBalanceIndex);

            if (s.charAt(0) == '(') {
                sb.append(u);
                sb.append(transform(v));
            } else {
                u = u.length() >= 2 ? u.substring(1, u.length() - 1) : "";
                u = u.replaceAll("\\(", "0")
                        .replaceAll("\\)", "\\(")
                        .replaceAll("0", "\\)");

                String sbs = "(" +
                        transform(v) +
                        ")" +
                        u;
                sb.append(transform(sbs));
            }

            return sb.toString();
        }
    }

    public int firstBalanceIndex(String s) {
        int index = 0;
        int ban = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ban += c == '(' ? 1 : -1;
            if (ban == 0) {
                index = i;
                break;
            }
        }

        return index + 1;
    }
}
