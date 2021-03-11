package com.ozragwort.code.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://devth-preview.goorm.io/exam/53763/devth-preview-kor/quiz/1
public class ex1 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean check = false;

        int N = Integer.parseInt(br.readLine());

        int[] questions = new int[N];
        String str = br.readLine();
        String[] split = str.split(" ");
        for(int i = 0; i < N; ++i){
            questions[i] = Integer.parseInt(split[i]);
        }

        for (int i : questions) {
            int highCount = 0;
            int lowCount = 0;
            for (int n = 0 ; n < N ; n++) {
                if (i < questions[n]) {
                    highCount++;
                } else if (i > questions[n]) {
                    lowCount++;
                }
            }
            if (highCount != 0 && lowCount != 0) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        br.close();
    }

}
