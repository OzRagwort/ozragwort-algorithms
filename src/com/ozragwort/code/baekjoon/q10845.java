package com.ozragwort.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class q10845 {
	class MyQueue {
		private static final String ERROR_MESSAGE = "-1";
		private static final String EMPTY_MESSAGE = "1";
		private static final String NON_EMPTY_MESSAGE = "0";

		private Deque<Integer> deque = new LinkedList<>();
		private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		public MyQueue() {
		}

		public void execute(String command) throws IOException {
			if (command.startsWith("push")) {
				int number = Integer.parseInt(command.split(" ")[1]);
				push(number);
				return;
			}
			if (command.startsWith("pop")) {
				pop();
				return;
			}
			if (command.startsWith("size")) {
				size();
				return;
			}
			if (command.startsWith("empty")) {
				empty();
				return;
			}
			if (command.startsWith("front")) {
				front();
				return;
			}
			if (command.startsWith("back")) {
				back();
			}
		}

		public void flush() throws IOException {
			bw.flush();
		}

		private void push(int number) {
			deque.offer(number);
		}

		private void pop() throws IOException {
			if (deque.isEmpty()) {
				bw.write(ERROR_MESSAGE + System.lineSeparator());
				return;
			}
			bw.write(deque.pop() + System.lineSeparator());
		}

		private void size() throws IOException {
			bw.write(deque.size() + System.lineSeparator());
		}

		private void empty() throws IOException {
			if (deque.isEmpty()) {
				bw.write(EMPTY_MESSAGE + System.lineSeparator());
				return;
			}
			bw.write(NON_EMPTY_MESSAGE + System.lineSeparator());
		}

		private void front() throws IOException {
			if (deque.isEmpty()) {
				bw.write(ERROR_MESSAGE + System.lineSeparator());
				return;
			}
			bw.write(deque.peekFirst() + System.lineSeparator());
		}

		private void back() throws IOException {
			if (deque.isEmpty()) {
				bw.write(ERROR_MESSAGE + System.lineSeparator());
				return;
			}
			bw.write(deque.peekLast() + System.lineSeparator());
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		MyQueue queue = new MyQueue();
		for (int i = 0; i < N; i++) {
			queue.execute(br.readLine());
		}

		queue.flush();
		br.close();
	}
}
