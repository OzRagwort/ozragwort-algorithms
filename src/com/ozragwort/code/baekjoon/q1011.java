package com.ozragwort.code.baekjoon;

import java.io.*;

public class q1011 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        while(N > 0) {
            String[] num = br.readLine().split(" ");
            int dist = Integer.parseInt(num[1]) - Integer.parseInt(num[0]);
            int subCounter = (int) Math.floor(Math.sqrt(dist - 1));
            int checkNum = (int) Math.floor(Math.sqrt(dist - subCounter - 1));

            if (checkNum == subCounter)
                bw.write(Integer.toString((subCounter * 2) + 1));
            else
                bw.write(Integer.toString(subCounter * 2));
            bw.newLine();

            N--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
/*
dist		counter		subcounter
1	1	1		1

2	11	2		1
3	111	3		2
4	121	3		2

5	1211	4		2
6	1221	4		2
7	12211	5		3
8	12221	5		3
9	12321	5		3

10	123211	6		3
11	123221	6		3
12	123321	6		3
13	1233211	7		4
14	1233221	7		4
15	1233321	7		4
16	1234321	7		4

17	12343211	8
18	12343221	8
19	12343321	8
20	12344321	8
21	123443211	9
22	123443221	9
23	123443321	9
24	123444321	9
25	123454321	9

26	1234543211	10
27	1234543221	10
28	1234543321	10
29	1234544321	10
30	1234554321	10
31	12345543211	11
32	12345543221	11
33	12345543321	11
34	12345544321	11
35	12345554321	11
36	12345654321	11
 */