package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class q5597 {

  static class ProgrammingClass {

    private static final int MAX_STUDENT = 30;

    private List<Integer> students = new ArrayList<>();

    public ProgrammingClass() {
      for (int i = 1; i <= MAX_STUDENT; i++) {
        students.add(i);
      }
    }

    public List<Integer> getStudentNotSubmit(List<Integer> submitted) {
      List<Integer> students = new ArrayList<>(this.students);
      students.removeAll(submitted);
      return students;
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int submitCount = 28;
    List<Integer> submitted = new ArrayList<>();
    for (int i = 0; i < submitCount; i++) {
      int student = Integer.parseInt(br.readLine());
      submitted.add(student);
    }
    ProgrammingClass programmingClass = new ProgrammingClass();
    for (Integer student : programmingClass.getStudentNotSubmit(submitted)) {
      System.out.println(student);
    }

    br.close();
  }
}
