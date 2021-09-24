package com.ozragwort.code.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class q60061 {
    boolean[][] tableColumn;
    boolean[][] tableBeam;

    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> result = new ArrayList<>();
        tableColumn = new boolean[n + 3][n + 3];
        tableBeam = new boolean[n + 3][n + 3];

        for (int[] frame : build_frame) {
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            int type = frame[2];
            int create = frame[3];

            if (create == 1) {
                if (type == 0) {
                    tableColumn[x][y] = checkDetail(x, y, type);
                } else {
                    tableBeam[x][y] = checkDetail(x, y, type);
                }
            } else {
                if (type == 0) {
                    tableColumn[x][y] = false;
                    tableColumn[x][y] = checkDetailDelete(x, y, type);
                } else {
                    tableBeam[x][y] = false;
                    tableBeam[x][y] = checkDetailDelete(x, y, type);
                }
            }
        }

        for (int i = 1 ; i < n + 2 ; i++) {
            for (int j = 1 ; j < n + 2 ; j++) {
                if (tableColumn[i][j]) {
                    result.add(new int[]{i - 1, j - 1, 0});
                }
                if (tableBeam[i][j]) {
                    result.add(new int[]{i - 1, j - 1, 1});
                }
            }
        }

        int[][] answer = new int[result.size()][3];
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public boolean checkDetail(int x, int y, int type) {
        boolean result = false;

        if (type == 0) {
            if (y == 1 || tableBeam[x - 1][y] || tableBeam[x][y] || tableColumn[x][y - 1]) {
                result = true;
            }
        } else {
            if ((tableBeam[x - 1][y] && tableBeam[x + 1][y]) || (tableColumn[x][y - 1] || tableColumn[x + 1][y - 1])) {
                result = true;
            }
        }

        return result;
    }

    public boolean checkDetailDelete(int x, int y, int type) {
        boolean result = true;

        if (type == 0) {
            if (tableBeam[x - 1][y + 1]) {
                result &= checkDetail(x - 1, y + 1, 1);
            }
            if (tableBeam[x][y + 1]) {
                result &= checkDetail(x, y + 1, 1);
            }
            if (tableColumn[x][y + 1]) {
                result &= checkDetail(x, y + 1, 0);
            }
        } else {
            if (tableBeam[x - 1][y]) {
                result &= checkDetail(x - 1, y, 1);
            }
            if (tableColumn[x][y]) {
                result &= checkDetail(x, y, 0);
            }
            if (tableBeam[x + 1][y]) {
                result &= checkDetail(x + 1, y, 1);
            }
            if (tableColumn[x + 1][y]) {
                result &= checkDetail(x + 1, y, 0);
            }
        }

        return !result;
    }
}
