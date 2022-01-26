package com.ozragwort.code.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class q2594 {
	static class Duration {
		private int duration;

		public Duration(int duration) {
			this.duration = duration;
		}

		public int get() {
			return duration;
		}
	}

	static class Time {
		private static final int HOUR = 60;

		private int time;

		public Time(String time) {
			time = String.format("%04d", Integer.parseInt(time));
			int hour = Integer.parseInt(time.substring(0, 2));
			int minute = Integer.parseInt(time.substring(2, 4));
			this.time = hour * HOUR + minute;
		}

		public Time(int time) {
			this.time = time;
		}

		public int get() {
			return time;
		}
	}

	static class Ride implements Comparable<Ride> {
		private Time start;
		private Time end;

		public Ride(Time start, Time end) {
			this.start = start;
			this.end = end;
		}

		public Time getStartTime() {
			return start;
		}

		public Time getEndTime() {
			return end;
		}

		@Override
		public int compareTo(Ride o) {
			if (this.start.get() > o.start.get()) {
				return 1;
			}
			if (this.start.get() < o.start.get()) {
				return -1;
			}
			if (this.end.get() > o.end.get()) {
				return 1;
			}
			return -1;
		}
	}

	static class Rides {
		private static final Time OPEN_TIME = new Time("1000");
		private static final Time CLOSE_TIME = new Time("2200");
		private static final int WAITING_DURATION = 10;

		private List<Ride> rides = new ArrayList<>();

		public Rides() {
		}

		public void add(Ride ride) {
			rides.add(ride);
		}

		public Duration getRestDuration() {
			PriorityQueue<Ride> sortedRides = new PriorityQueue<>(rides);

			Time prevTime = new Time(OPEN_TIME.get() - WAITING_DURATION);
			int maxDuration = 0;
			while (sortedRides.size() > 0) {
				Ride ride = sortedRides.poll();
				int start = ride.getStartTime().get();
				maxDuration = Math.max(maxDuration, Math.max(start - prevTime.get() - (WAITING_DURATION * 2), 0));
				if (prevTime.get() < ride.getEndTime().get()) {
					prevTime = ride.getEndTime();
				}
			}
			maxDuration = Math.max(maxDuration, Math.max(CLOSE_TIME.get() - WAITING_DURATION - prevTime.get(), 0));
			return new Duration(maxDuration);
		}
	}

	static class InputView {
		private static final String TIME_REGEX = " ";

		public static Rides inputRides() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			Rides rides = new Rides();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String[] times = br.readLine().split(TIME_REGEX);
				Time start = new Time(times[0]);
				Time end = new Time(times[1]);
				Ride ride = new Ride(start, end);
				rides.add(ride);
			}

			br.close();
			return rides;
		}
	}

	static class OutputView {
		public static void output(Duration duration) {
			System.out.println(duration.get());
		}
	}

	public void solution() throws IOException {
		Rides rides = InputView.inputRides();
		OutputView.output(rides.getRestDuration());
	}
}
