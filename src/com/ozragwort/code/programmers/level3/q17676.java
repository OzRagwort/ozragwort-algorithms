package com.ozragwort.code.programmers.level3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class q17676 {
    public int solution(String[] lines) {
        LocalDateTime[][] dts = new LocalDateTime[lines.length][2];
        LocalDateTime[][] startSortDts = new LocalDateTime[lines.length][2];
        int max = 0;

        for (int i = 0 ; i < lines.length ; i++) {
            dts[i] = getLocalDateTime(lines[i]);
        }

        for (int i = 0 ; i < dts.length ; i++) {
            System.arraycopy(dts[i], 0, startSortDts[i], 0, dts[i].length);
        }

        Arrays.sort(startSortDts, Comparator.comparing(o -> o[0]));

        for (int i = 0 ; i < dts.length ; i++) {
            int count = 0;
            for (int j = i ; j < dts.length ; j++) {
                int comS = dts[i][1].plusSeconds(1).compareTo(startSortDts[j][0]);

                if (comS < 0) {
                    break;
                } else {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
        }

        return max;
    }

    public LocalDateTime[] getLocalDateTime(String line) {
        LocalDateTime[] localDateTimes = new LocalDateTime[2];
        String[] s = line.split(" ");

        int[] ldate = Arrays.stream(s[0].split("-")).mapToInt(Integer::parseInt).toArray();
        String[] ltime = s[1].split(":");
        int[] lsecond = Arrays.stream(ltime[2].split("\\.")).mapToInt(Integer::parseInt).toArray();

        LocalDate localDate = LocalDate.of(ldate[0], ldate[1], ldate[2]);
        LocalTime localtime = LocalTime.of(Integer.parseInt(ltime[0]), Integer.parseInt(ltime[1]), lsecond[0], lsecond[1] * 1000000);

        localDateTimes[1] = LocalDateTime.of(localDate, localtime);

        s[2] = s[2].replace("s", "");
        int[] process = new int[2];
        String[] psplit = s[2].split("\\.");
        for (int i = 0 ; i < psplit.length ; i++) {
            process[i] = Integer.parseInt(psplit[i]);
        }

        localDateTimes[0] = localDateTimes[1].minusSeconds(process[0]).minusNanos((process[1] - 2) * 1000000L);

        return localDateTimes;
    }
}
