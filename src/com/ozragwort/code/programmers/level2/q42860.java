package com.ozragwort.code.programmers.level2;

public class q42860 {
    public int solution(String name) {
        int answer = 0;
        boolean[] visit = new boolean[name.length()];

        for (int i = 0 ; i < name.length() ; i++) {
            if (name.charAt(i) == 'A') {
                visit[i] = true;
            }
        }

        int p = 0;
        int move = 0;
        do {
            // 알파벳 조작(위아래 조작 횟수)
            int alpha = name.charAt(p) - 65;
            answer += Math.min(alpha, 26 - alpha);
            visit[p] = true;

            // 다음 위치 찾기(좌우 조작 횟수)
            move = nextMove(visit, p, name.length());
            answer += Math.abs(move);
            p = (name.length() + p + move) % name.length();
        } while (move != 0);

        return answer;
    }

    public int nextMove(boolean[] visit, int index, int length) {
        for (int i = 1 ; i < length ; i++) {
            int right = (index + i) % length;
            int left = (length + index - i) % length;

            if (!visit[right]) {
                return i;
            } else if (!visit[left]) {
                return i * -1;
            }
        }
        return 0;
    }
}
