package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2441 {

  static class Star {

    public static final String STAR = "*";
    public static final String SPACE = " ";

    public Star() {
    }

    public String getOutput(int n) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          builder.append(SPACE);
        }
        for (int j = i; j < n; j++) {
          builder.append(STAR);
        }
        builder.append(System.lineSeparator());
      }
      return builder.toString();
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Star star = new Star();
    System.out.print(star.getOutput(N));

    br.close();
  }
}
