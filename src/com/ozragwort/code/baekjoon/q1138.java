package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q1138 {

  public static final String SPACE = " ";

  static class LineUp {

    public LineUp() {
    }

    public int[] getOrderBy(int[] leftOnLeft) {
      int[] order = new int[leftOnLeft.length];
      for (int i = 0; i < leftOnLeft.length; i++) {
        order[getLeftIndex(order, leftOnLeft[i])] = i + 1;
      }
      return order;
    }

    private int getLeftIndex(int[] order, int orderLeft) {
      for (int i = 0; i < order.length; i++) {
        if (orderLeft == 0 && order[i] == 0) {
          return i;
        }
        if (order[i] == 0) {
          orderLeft--;
        }
      }
      throw new IllegalArgumentException();
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer stk = new StringTokenizer(br.readLine());

    int[] leftOnLeft = new int[N];
    for (int i = 0; i < N; i++) {
      leftOnLeft[i] = Integer.parseInt(stk.nextToken());
    }

    LineUp lineUp = new LineUp();
    for (int people : lineUp.getOrderBy(leftOnLeft)) {
      bw.write(people + SPACE);
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
