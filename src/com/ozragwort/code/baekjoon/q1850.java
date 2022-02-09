package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1850 {

  static class OneConvertor {

    public static String convert(long count) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < count; i++) {
        sb.append("1");
      }
      return sb.toString();
    }
  }

  static class GCD {

    public static long get(long number1, long number2) {
      long big = Math.max(number1, number2);
      long small = Math.min(number1, number2);
      return euclidean(big, small);
    }

    private static long euclidean(long big, long small) {
      if (small == 0) {
        return big;
      }
      return euclidean(small, big % small);
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stk = new StringTokenizer(br.readLine());
    long A = Long.parseLong(stk.nextToken());
    long B = Long.parseLong(stk.nextToken());
    System.out.println(OneConvertor.convert(GCD.get(A, B)));

    br.close();
  }
}
