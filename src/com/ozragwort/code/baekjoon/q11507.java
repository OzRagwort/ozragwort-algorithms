package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q11507 {
	private static final int SET_LENGTH = 3;
	private static final String GRESKA_MESSAGE = "GRESKA";
	private static final String DUPLICATE_ERROR_MESSAGE = "중복된 카드가 있습니다.";

	enum CardTypes {
		SPADE("P"),
		HEART("K"),
		DIAMOND("H"),
		CLOVER("T");

		private final String s;

		CardTypes(String s) {
			this.s = s;
		}

		public String get() {
			return s;
		}
	}

	class Cards {
		private static final int MIN_NUMBER = 1;
		private static final int MAX_NUMBER = 13;
		private static final int TOTAL_COUNT = 13;
		private static final String TYPE_ERROR_MESSAGE = "타입이 잘못됐습니다.";
		private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자의 형식이 잘못되었습니다.";
		private static final String NUMBER_ERROR_MESSAGE = "숫자는 "
			+ MIN_NUMBER + "이상 " + MAX_NUMBER + "이하로 입력해야 합니다.";

		private HashMap<String, List<Integer>> cards = new HashMap<>();

		public Cards() {
			for (CardTypes cardTypes : CardTypes.values()) {
				cards.put(cardTypes.get(), new ArrayList<>());
			}
		}

		public int getLostCardCount(String type) {
			return TOTAL_COUNT - cards.get(type).size();
		}

		public boolean addCard(String input) {
			String type = input.substring(0, 1);
			String stringNumber = input.substring(1, 3);
			validateType(type);
			validateNumberFormat(stringNumber);
			int number = Integer.parseInt(stringNumber);
			validateNumber(number);

			if (cards.get(type).contains(number)) {
				return false;
			}
			cards.get(type).add(number);
			return true;
		}

		private void validateType(final String type) {
			if (!cards.containsKey(type)) {
				throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
			}
		}

		private void validateNumberFormat(String stringNumber) {
			try {
				Integer.parseInt(stringNumber);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
			}
		}

		private void validateNumber(final int number) {
			if (number < MIN_NUMBER || MAX_NUMBER < number) {
				throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();

		Cards cards = new Cards();
		try {
			setCard(cards, S);
			printLostCardCount(cards, bw);
		} catch (IllegalArgumentException e) {
			bw.write(GRESKA_MESSAGE);
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private void setCard(Cards cards, String S) {
		for (int i = 0; i < S.length(); i += SET_LENGTH) {
			if (cards.addCard(S.substring(i, i + SET_LENGTH))) {
				continue;
			}
			throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
		}
	}

	private void printLostCardCount(Cards cards, BufferedWriter bw) throws IOException {
		for (CardTypes cardTypes : CardTypes.values()) {
			String type = cardTypes.get();
			bw.write(cards.getLostCardCount(type) + " ");
		}
	}
}
