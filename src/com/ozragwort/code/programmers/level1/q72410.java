package com.ozragwort.code.programmers.level1;

public class q72410 {
    public String solution(String new_id) {
        return checkId(new_id);
    }

    public String checkId(String id) {
        // 1
        id = toLowerCase(id);
        // 2,3
        id = replaceSpecial(id);
        // 4
        id = removeDot(id);
        // 5,6,7
        id = lengthCheck(id);

        return id;
    }

    public String toLowerCase(String id) {
        return id.toLowerCase();
    }

    public String replaceSpecial(String id) {
        return id.replaceAll("[^a-z0-9\\-_.]", "").replaceAll("\\.{2,}+", ".");
    }

    public String removeDot(String id) {
        if (id.startsWith(".")) {
            id = id.substring(1);
        }
        if (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }
        return id;
    }

    public String lengthCheck(String id) {
        if (id.length() == 0) {
            id = "a";
        }

        if (id.length() >= 16) {
            id = removeDot(id.substring(0, 15));
        }

        if (id.length() <= 2) {
            StringBuilder sb = new StringBuilder(id);
            while (sb.length() < 3) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            id = sb.toString();
        }

        return id;
    }
}
