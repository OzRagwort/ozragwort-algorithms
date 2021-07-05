package com.ozragwort.code.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class q42583 {
    class Truck {
        private int weight;
        private int moveDist;

        public Truck() {}

        public Truck(int weight) {
            this.weight = weight;
            this.moveDist = 0;
        }

        public void movingTruck() {
            moveDist++;
        }

        public int getWeight() {
            return weight;
        }

        public int getMoveDist() {
            return moveDist;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitTruck = new LinkedList<>();
        Queue<Truck> moveTruck = new LinkedList<>();
        int nowWeight = 0;
        int time = 0;

        for (int truck_weight : truck_weights) {
            waitTruck.offer(new Truck(truck_weight));
        }

        while (!waitTruck.isEmpty() || !moveTruck.isEmpty()) {
            time++;

            if (!moveTruck.isEmpty()) {
                for (Truck truck : moveTruck) {
                    truck.movingTruck();
                }

                if (moveTruck.peek().getMoveDist() == bridge_length) {
                    nowWeight -= moveTruck.poll().getWeight();
                }
            }

            if (!waitTruck.isEmpty()) {
                if (nowWeight + waitTruck.peek().weight <= weight) {
                    nowWeight += waitTruck.peek().getWeight();
                    moveTruck.offer(waitTruck.poll());
                }
            }
        }

        return time;
    }

//    3~4배 빠른 방식
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        int time = 0;
//        int nowWeight = 0;
//        int nowInBridge = 0;
//        int i = 0;
//        Queue<Integer[]> cross_truck = new LinkedList<>();
//
//        while (i < truck_weights.length || !cross_truck.isEmpty()) {
//            if (!cross_truck.isEmpty()) {
//                if (bridge_length == time - cross_truck.peek()[1]) {
//                    Integer[] pass_truck = cross_truck.poll();
//                    nowWeight -= pass_truck[0];
//                    nowInBridge--;
//                }
//            }
//
//            if (i < truck_weights.length && nowInBridge <= bridge_length && nowWeight + truck_weights[i] <= weight) {
//                cross_truck.offer(new Integer[]{truck_weights[i], time});
//                nowWeight += truck_weights[i];
//                nowInBridge++;
//                i++;
//            }
//
//            time++;
//        }
//
//        return time;
//    }
}
