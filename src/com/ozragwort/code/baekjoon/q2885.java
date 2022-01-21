package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2885 {
	static class Chocolate {
		private int length;

		public Chocolate(int length) {
			this.length = length;
		}

		public int getMinLengthByPow2() {
			int pow = 1;
			while (pow < length) {
				pow *= 2;
			}
			return pow;
		}

		public int getMinCutCount() {
			int pow = getMinLengthByPow2();
			int count = 0;
			int length = 0;
			while (length < this.length) {
				if (length + pow <= this.length) {
					length += pow;
				}
				if (length == this.length) {
					break;
				}
				count++;
				pow /= 2;
			}
			return count;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());
		Chocolate chocolate = new Chocolate(K);
		int length = chocolate.getMinLengthByPow2();
		int count = chocolate.getMinCutCount();
		System.out.println(length + " " + count);

		bw.flush();
		bw.close();
		br.close();
	}
}
