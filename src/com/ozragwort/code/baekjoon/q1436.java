package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1436 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int name = 665;

        while(N > 0) {
            name++;
            int buf = name;
            while(buf > 100) {
                if (buf % 1000 == 666) {
                    N--;
                    break;
                }
                buf /= 10;
            }
        }
//        브루트포스로 풀 경우 (String.contains) -> (느림)
//        int name = 665;
//
//        while(N-- > 0) {
//            name++;
//            while(!Integer.toString(name).contains("666")) {
//                name++;
//            }
//        }
//
//        bw.write(Integer.toString(name));
        bw.flush();
        bw.close();
        br.close();
    }
}
