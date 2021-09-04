package com.ozragwort.code.programmers.level2;

public class q17683 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = 0;

        for (String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            int start = timeToInt(infos[0]);
            int end = timeToInt(infos[1]);
            int playTime = end - start;

            if (playTime > len) {
                String playLog = "";
                StringBuilder sb = new StringBuilder();
                int sharpCount = getSharpCount(infos[3]);
                int i = 0;

                while (sb.length() - sharpCount * i < playTime) {
                    sb.append(infos[3]);
                    i++;
                }
                sharpCount *= i;

                while (sb.length() - sharpCount > playTime) {
                    if (sb.charAt(sb.length() - 1) == '#') {
                        sharpCount--;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }

                playLog = sb.toString().replaceAll(m + "#", "");

                int sharpCheck = playLog.indexOf(m) + m.length();
                if (playLog.contains(m)) {
                    if (!(sharpCheck < playLog.length() && playLog.charAt(sharpCheck) == '#')) {
                        len = playTime;
                        answer = infos[2];
                    }
                }
            }
        }

        return answer;
    }

    public int timeToInt(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    public int getSharpCount(String s) {
        return s.length() - s.replaceAll("#", "").length();
    }
}
