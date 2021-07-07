package com.ozragwort.code.programmers.level3;

public class q49191 {
    public int solution(int n, int[][] results) {
        boolean[][] winTable = new boolean[n + 1][n + 1];
        boolean[][] loseTable = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            winTable[result[0]][result[1]] = true;
            loseTable[result[1]][result[0]] = true;
        }

        for (int mid = 1 ; mid <= n ; mid++) {
            for (int start = 1 ; start <= n ; start++) {
                for (int end = 1 ; end <= n ; end++) {
                    if (start == end) {
                        continue;
                    }
                    winTable[start][end] |= winTable[start][mid] && winTable[mid][end];
                    loseTable[start][end] |= loseTable[start][mid] && loseTable[mid][end];
                }
            }
        }

        int answer = 0;
        for (int i = 1 ; i <= n ; i++) {
            boolean check = true;
            for (int j = 1 ; j <= n ; j++) {
                // i, j가 다르고 한번도 마주치지 않은 경우
                if (i != j && !(winTable[i][j] || loseTable[i][j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }

        return answer;
    }
}
