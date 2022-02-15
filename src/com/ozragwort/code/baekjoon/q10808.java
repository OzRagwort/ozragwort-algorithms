package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q10808 {

  static class Alphabet {

    public int[] getArray(String word) {
      int[] array = new int[26];
      for (int i = 0; i < word.length(); i++) {
        array[word.charAt(i) - 97]++;
      }
      return array;
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Alphabet alphabet = new Alphabet();
    int[] array = alphabet.getArray(br.readLine());
    for (int i = 0; i < array.length; i++) {
      bw.write(array[i] + " ");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
