package com.ozragwort.code.programmers.level4;

public class q12920 {
    final int MAX_WORKING_TIME = 10000;

    public int solution(int n, int[] cores) {
        int lastCore = 0;
        int finishTime = 0;
        int restCount = 0;

        // 종료되는 시간
        finishTime = getFinishTime(n, cores);
        // 종료-1 시간에 남은 작업 수
        restCount = n - numByTime(finishTime - 1, cores);

        // 남은 작업 실행
        for (int i = 0 ; i < cores.length ; i++) {
            if ((finishTime - 1) % cores[i] == 0) {
                restCount--;
            }
            if (restCount == 0) {
                lastCore = i + 1;
                break;
            }
        }

        return lastCore;
    }

    public int getFinishTime(int n, int[] cores) {
        int left = 1;
        int right = n * MAX_WORKING_TIME;
        int mid = (right + left) / 2;

        while (left < right) {
            if (numByTime(mid, cores) >= n)
                right = mid;
            else
                left = mid + 1;
            mid = (right + left) / 2;
        }

        return mid;
    }

    public int numByTime(int t, int[] cores) {
        int sum = 0;
        for (int core : cores) {
            sum += t / core + (t % core == 0 ? 0 : 1);
        }
        return sum;
    }
}
