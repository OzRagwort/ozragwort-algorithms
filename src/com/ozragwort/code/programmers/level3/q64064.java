package com.ozragwort.code.programmers.level3;

import java.util.HashSet;

public class q64064 {
    String[] user_id, banned_id;
    HashSet<Integer> countSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        int user_visit_bin = 256;

        dfs(user_visit_bin, 0);

        return countSet.size();
    }

    public void dfs(int visit, int banned_id_index) {
        if (banned_id.length == banned_id_index) {
            countSet.add(visit);
        } else {
            for (int i = 0 ; i < user_id.length ; i++) {
                if (user_visit_bin(visit, i)) {
                    continue;
                } else {
                    if (check(user_id[i], banned_id[banned_id_index])) {
                        visit ^= (int) Math.pow(2, i);
                        dfs(visit, banned_id_index + 1);
                        visit ^= (int) Math.pow(2, i);
                    }
                }
            }
        }
    }

    public boolean user_visit_bin(int visit, int index) {
        visit >>= index;
        return visit % 2 == 1;
    }

    public boolean check(String user, String banned) {
        if (user.length() == banned.length()) {
            for (int i = 0 ; i < user.length() ; i++) {
                if (banned.charAt(i) == '*' || user.charAt(i) == banned.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
