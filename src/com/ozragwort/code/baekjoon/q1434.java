package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q1434 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		List<Integer> box = new ArrayList<>();
		List<Integer> book = new ArrayList<>();

		setup(box, new StringTokenizer(br.readLine()));
		setup(book, new StringTokenizer(br.readLine()));
		makeUp(box, book);

		int wasted = box.stream().mapToInt(Integer::intValue).sum();
		System.out.println(wasted);

		br.close();
	}

	private void makeUp(List<Integer> box, List<Integer> book) {
		int boxIndex = 0;
		int bookIndex = 0;

		while (boxIndex < box.size() && bookIndex < book.size()) {
			int remainBox = box.get(boxIndex);
			int remainBook = book.get(bookIndex);

			if (remainBox < remainBook) {
				boxIndex++;
			} else {
				box.set(boxIndex, remainBox - remainBook);
				book.set(bookIndex, 0);
				bookIndex++;
			}
		}
	}

	private void setup(List<Integer> list, StringTokenizer stk) {
		while (stk.hasMoreTokens()) {
			list.add(Integer.parseInt(stk.nextToken()));
		}
	}
}
