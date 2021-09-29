package com.ozragwort.code.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class q42889 {
    class Stage {
        int challenger;
        int fail;

        public Stage(int challenger, int fail) {
            this.challenger = challenger;
            this.fail = fail;
        }

        public double getFailRate() {
            if (challenger == 0) {
                return 0;
            } else {
                return (double) fail / challenger;
            }
        }

        public void setChallenger(int challenger) {
            this.challenger = challenger;
        }

        public void setFail(int fail) {
            this.fail = fail;
        }

        public int getChallenger() {
            return challenger;
        }

        public int getFail() {
            return fail;
        }

        public void addFail() {
            this.fail++;
        }
    }

    public int[] solution(int N, int[] stages) {
        Stage[] stageArr = new Stage[N + 2];

        for (int i = 0 ; i <= N + 1 ; i++) {
            stageArr[i] = new Stage(0, 0);
        }

        for (int stage : stages) {
            stageArr[stage].addFail();
        }

        stageArr[0].setChallenger(stages.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= N ; i++) {
            stageArr[i].setChallenger(
                    stageArr[i - 1].getChallenger() - stageArr[i - 1].getFail()
            );
            list.add(i);
        }

        list.sort((o1, o2) -> {
            if (stageArr[o1].getFailRate() == stageArr[o2].getFailRate()) {
                return o1 - o2;
            } else {
                if (stageArr[o2].getFailRate() - stageArr[o1].getFailRate() > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
