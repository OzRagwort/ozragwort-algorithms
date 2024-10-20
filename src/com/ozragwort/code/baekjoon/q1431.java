package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q1431 {
    static class SerialNumber {
        private String number;

        public SerialNumber(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        private int sumOfDigits() {
            int sum = 0;
            for (char c : number.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += Character.getNumericValue(c);
                }
            }
            return sum;
        }

        public int compareTo(SerialNumber serialNumber) {
            int lengthCompare = Integer.compare(this.number.length(), serialNumber.number.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }

            int digitSumCompare = Integer.compare(this.sumOfDigits(), serialNumber.sumOfDigits());
            if (digitSumCompare != 0) {
                return digitSumCompare;
            }

            return number.compareTo(serialNumber.getNumber());
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<SerialNumber> serialNumbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            SerialNumber serialNumber = new SerialNumber(stk.nextToken());
            serialNumbers.add(serialNumber);
        }

        serialNumbers.sort(SerialNumber::compareTo);
        for (SerialNumber serialNumber : serialNumbers) {
            bw.write(serialNumber.getNumber());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
