package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class q11723 {
	static class Command {
		private static final String ADD = "add";
		private static final String REMOVE = "remove";
		private static final String CHECK = "check";
		private static final String TOGGLE = "toggle";
		private static final String ALL = "all";
		private static final String EMPTY = "empty";

		private String command;
		private int number;

		public Command(String command) {
			String[] c = command.trim().split(" ");
			if (c.length < 2) {
				this.command = c[0];
				return;
			}
			this.command = c[0];
			this.number = Integer.parseInt(c[1]);
		}

		public int getNumber() {
			return number;
		}

		public boolean isAdd() {
			return command.equals(ADD);
		}

		public boolean isRemove() {
			return command.equals(REMOVE);
		}

		public boolean isCheck() {
			return command.equals(CHECK);
		}

		public boolean isToggle() {
			return command.equals(TOGGLE);
		}

		public boolean isAll() {
			return command.equals(ALL);
		}

		public boolean isEmpty() {
			return command.equals(EMPTY);
		}
	}

	static class Set {
		private static final String HAS_VALUE = "1";
		private static final String HAS_NOT_VALUE = "0";

		private final List<Integer> set;

		public Set() {
			set = new ArrayList<>();
		}

		public String command(Command command) {
			if (command.isAdd()) {
				add(command.getNumber());
				return null;
			}
			if (command.isRemove()) {
				remove(command.getNumber());
				return null;
			}
			if (command.isCheck()) {
				return check(command.getNumber());
			}
			if (command.isToggle()) {
				toggle(command.getNumber());
				return null;
			}
			if (command.isAll()) {
				all();
				return null;
			}
			if (command.isEmpty()) {
				empty();
				return null;
			}
			return null;
		}

		private void add(int number) {
			set.add(number);
		}

		private void remove(int number) {
			set.remove((Object)number);
		}

		private String check(int number) {
			if (set.contains(number)) {
				return HAS_VALUE;
			}
			return HAS_NOT_VALUE;
		}

		private void toggle(int number) {
			if (set.contains(number)) {
				remove(number);
				return;
			}
			add(number);
		}

		private void all() {
			empty();
			for (int i = 1; i <= 20; i++) {
				set.add(i);
			}
		}

		private void empty() {
			set.clear();
		}
	}

	static class InputView {
		private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		public int readCount() throws IOException {
			String input = bufferedReader.readLine();
			return Integer.parseInt(input);
		}

		public Command readCommand() throws IOException {
			return new Command(bufferedReader.readLine());
		}
	}

	static class OutputView {
		private final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		public OutputView() {
		}

		public void write(String x) throws IOException {
			bufferedWriter.write(x);
		}

		public void newLine() throws IOException {
			bufferedWriter.newLine();
		}

		public void flush() throws IOException {
			bufferedWriter.flush();
		}
	}

	public void solution() throws IOException {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		int count = inputView.readCount();
		Set set = new Set();
		for (int i = 0; i < count; i++) {
			Command command = inputView.readCommand();
			String result = set.command(command);
			if (result != null) {
				outputView.write(result);
				outputView.newLine();
			}
		}
		outputView.flush();
	}
}
