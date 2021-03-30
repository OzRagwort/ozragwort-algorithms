package com.ozragwort.code.baekjoon;

import java.io.*;

public class q9663 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean[][] board;
    int N;
    int counter = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        int depth = 0;

        for (int i = 0 ; i < N ; i++) {
            func(depth, 0, i);
        }

        bw.write(counter+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int depth, int x, int y) {
        if (depth == (N - 1)) {
            if (setState(x, y)) {
                counter++;
            }
        } else {
            if (!board[x][y]) {
                if (setState(x, y)) {
                    board[x][y] = true;
                    depth++;
                    for (int j = 0 ; j < N ; j++) {
                        func(depth, x + 1, j);
                    }
                    board[x][y] = false;
                }
            }
        }
    }

    public boolean setState(int x, int y) {
        for (int i = 0 ; i < x ; i++) {
            if (board[i][y]) {
                return false;
            }
            if (y - (x - i) >= 0) {
                if (board[i][y - (x - i)]) {
                    return false;
                }
            }
            if (y + (x - i) < N) {
                if (board[i][y + (x - i)]) {
                    return false;
                }
            }
        }
        return true;
    }

}

/*
package com.ozragwort.code.baekjoon;

import java.io.*;

public class q0 {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean[][] board;
    int N;
    int counter = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        int depth = 0;

        for (int i = 0 ; i < N ; i++) {
            func(depth, 0, i);
        }

        bw.write(counter+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void func(int depth, int x, int y) {
        if (depth == (N - 1)) {
            if (setState(x, y)) {
                counter++;
            }
        } else {
            if (!board[x][y]) {
                if (setState(x, y)) {
                    board[x][y] = true;
                    depth++;
                    for (int j = 0 ; j < N ; j++) {
                        func(depth, x + 1, j);
                    }
                    board[x][y] = false;
                }
            }
        }
    }

    public boolean setState(int x, int y) {
        for (int i = 0 ; i < N ; i++) {
            if (board[x][i] || board[i][y]) {
                return false;
            }
            if ((x + i < N) && (y + i < N))
                if (board[x + i][y + i])
                    return false;
            if ((x - i >= 0) && (y - i >= 0))
                if (board[x - i][y - i])
                    return false;
            if ((x + i < N) && (y - i >= 0))
                if (board[x + i][y - i])
                    return false;
            if ((x - i >= 0) && (y + i < N))
                if (board[x - i][y + i])
                    return false;
        }
        return true;
    }

}
 */