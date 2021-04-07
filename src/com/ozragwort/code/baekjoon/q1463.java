package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1463 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] table = new boolean[3000000];
        int N = Integer.parseInt(br.readLine());
        int counter = 0;
        boolean check = true;

        if (N > 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            table[0] = true;

            while (check) {
                counter++;
                List<Integer> tempList = new ArrayList<>(list);
                list = new ArrayList<>();
                for (int i : tempList) {
                    if (i < N) {
                        if (!table[i]) {
                            table[i] = true;
                            if ((i + 1) == N) {
                                check = false;
                                break;
                            } else {
                                list.add(i + 1);
                            }
                        } if (!table[(i * 2) - 1]) {
                            table[(i * 2) - 1] = true;
                            if ((i * 2) == N) {
                                check = false;
                                break;
                            } else {
                                list.add(i * 2);
                            }
                        } if (!table[(i * 3) - 1]) {
                            table[(i * 3) - 1] = true;
                            if ((i * 3) == N) {
                                check = false;
                                break;
                            } else {
                                list.add(i * 3);
                            }
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(counter));

        bw.flush();
        bw.close();
        br.close();
    }
}
