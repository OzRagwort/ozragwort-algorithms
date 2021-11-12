package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1406 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> listIterator = list.listIterator();

        String in = br.readLine();

        for (int i = 0 ; i < in.length() ; i++) {
            listIterator.add(in.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String[] com = br.readLine().split(" ");
            switch (com[0]) {
                case "L":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                case "D":
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                case "B":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                default:
                    listIterator.add(com[1].charAt(0));
                    break;
            }
        }

        for (char s : list) {
            bw.write(s);
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
