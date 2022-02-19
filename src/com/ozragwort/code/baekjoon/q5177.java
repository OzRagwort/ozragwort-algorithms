package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q5177 {

    private static final String EQUAL_PRINT_FORM = "Data Set %d: equal\n\n";
    private static final String NOT_EQUAL_PRINT_FORM = "Data Set %d: not equal\n\n";

    static class CheckPrint {

        public boolean checkEquals(String a, String b) {
            String replaceA = replaceSpecialSpace(replace(a));
            String replaceB = replaceSpecialSpace(replace(b));
            return replaceA.equals(replaceB);
        }

        private String replace(String s) {
            return s.trim()
                    .toLowerCase()
                    .replaceAll("[\\[{]", "(")
                    .replaceAll("[]}]", ")")
                    .replaceAll(",", ";")
                    .replaceAll("[ ]+", " ");
        }

        private String replaceSpecialSpace(String s) {
            return s.replaceAll("[ ]*[(][ ]*", "(")
                    .replaceAll("[ ]*[)][ ]*", ")")
                    .replaceAll("[ ]*[:][ ]*", ":")
                    .replaceAll("[ ]*[;][ ]*", ";")
                    .replaceAll("[ ]*[\\.][ ]*", "\\.");
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        CheckPrint checkPrint = new CheckPrint();
        for (int i = 1; i <= K; i++) {
            String a = br.readLine();
            String b = br.readLine();
            bw.write(generateMessage(checkPrint, i, a, b));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private String generateMessage(CheckPrint checkPrint, int i, String a, String b) {
        if (checkPrint.checkEquals(a, b)) {
            return String.format(EQUAL_PRINT_FORM, i);
        }
        return String.format(NOT_EQUAL_PRINT_FORM, i);
    }
}
