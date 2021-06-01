package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class q1953 {

    int n;
    boolean[][] people;
    boolean[][] team;
    int[] teamCounter = new int[2];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        n = Integer.parseInt(br.readLine());
        people = new boolean[n + 1][n + 1];
        team = new boolean[n + 1][2];

        for (int i = 1 ; i <= n ; i++) {
            stk = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(stk.nextToken());

            for (int j = 0 ; j < count ; j++) {
                int hateMember = Integer.parseInt(stk.nextToken());
                people[i][hateMember] = people[hateMember][i] = true;
            }
        }

        for (int i = 1 ; i <= n ; i++) {
            makeTeam(i);
        }

        bw.write(teamCounter[0] + "\n");
        for (int i = 1 ; i <= n ; i++) {
            if (team[i][0]) {
                bw.write(i + " ");
            }
        }
        bw.newLine();
        bw.write(teamCounter[1] + "\n");
        for (int i = 1 ; i <= n ; i++) {
            if (team[i][1]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void makeTeam(int i) {
        int ourTeam = 0;
        int orderTeam = 1;

        if (team[i][1]) {
            ourTeam = 1;
            orderTeam = 0;
        }

        if (!team[i][ourTeam]) {
            team[i][ourTeam] = true;
            teamCounter[ourTeam]++;
        }

        for (int j = 1 ; j <= n ; j++) {
            if (people[i][j] && !(team[j][0] || team[j][1])) {
                team[j][orderTeam] = true;
                teamCounter[orderTeam]++;
                makeTeam(j);
            }
        }
    }
}
