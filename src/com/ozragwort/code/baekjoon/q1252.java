package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class q1252 {

  static class BinarySum {

    public String sum(String[] binarys) {
      BigInteger sum = BigInteger.ZERO;
      for (String binary : binarys) {
        sum = sum.add(new BigInteger(binary, 2));
      }
      return sum.toString(2);
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BinarySum binarySum = new BinarySum();
    String input = br.readLine();
    System.out.println(binarySum.sum(input.split(" ")));

    br.close();
  }
}
