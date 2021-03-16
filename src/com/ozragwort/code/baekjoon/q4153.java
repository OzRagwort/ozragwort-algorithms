package com.ozragwort.code.baekjoon;

import java.io.*;

public class q4153 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S;
        while(!(S = br.readLine()).equals("0 0 0")) {
            String[] num = S.split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            int c = Integer.parseInt(num[2]);

            if ((a * a) + (b * b) == (c * c)) {
                bw.write("right");
            } else if ((a * a) + (c * c) == (b * b)) {
                bw.write("right");
            } else if ((b * b) + (c * c) == (a * a)) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }
            bw.newLine();
        }
//        while(!(S = br.readLine()).equals("0 0 0")) {
//            String[] num = S.split(" ");
//            int a = Math.min(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
//            int b = Math.min(Math.max(Integer.parseInt(num[0]), Integer.parseInt(num[1])), Integer.parseInt(num[2]));
//            int c = Math.max(Math.max(Integer.parseInt(num[0]), Integer.parseInt(num[1])), Integer.parseInt(num[2]));
//
//            if ((a * a) + (b * b) == (c * c)) {
//                bw.write("right");
//            } else {
//                bw.write("wrong");
//            }
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
