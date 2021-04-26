package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1966 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> q = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        for (int i = 0 ; i < T ; i++) {
            // N, M 입력
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            Integer[] numArray = new Integer[N];

            // 중요도 입력
            stk = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                numArray[j] = Integer.parseInt(stk.nextToken());
                q.offer(numArray[j]);
            }

            // 출력 순서 확인
            int counter = printerQueue(numArray, q, M);

            bw.write(counter + "\n");
            q.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int printerQueue(Integer[] numArray, LinkedList<Integer> q, int M) {
        Arrays.sort(numArray, Collections.reverseOrder());

        int counter = 1;
        int numArrayIndex = 0;

        while (!(M == 0 && q.peek() == numArray[numArrayIndex])) {
            int n = q.poll();

            if (n == numArray[numArrayIndex]) {
                counter++;
                M--;
                numArrayIndex++;
            } else {
                q.offer(n);
                if (M == 0) {
                    M = q.size() - 1;
                } else {
                    M--;
                }
            }
        }

        return counter;
    }
}
