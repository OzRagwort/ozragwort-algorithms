package com.ozragwort.code.programmers.level3;

import java.util.Stack;

public class q77886 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        Stack<Byte> stack = new Stack<>();
        int counter = 0;

        for (int r = 0 ; r < s.length ; r++) {
            byte[] sb = s[r].getBytes();

            for (int i = 0 ; i < s[r].length() ; i++) {
                stack.push(sb[i]);

                if (stack.size() >= 3) {
                    byte[] numbers = new byte[3];
                    numbers[2] = stack.pop();
                    numbers[1] = stack.pop();
                    numbers[0] = stack.pop();

                    if (numbers[0] == '1' && numbers[1] == '1' && numbers[2] == '0') {
                        counter++;
                    } else {
                        stack.push(numbers[0]);
                        stack.push(numbers[1]);
                        stack.push(numbers[2]);
                    }
                }
            }


            byte[] result = new byte[sb.length];
            int index = sb.length - 1;

            while (index >= 0) {
                if (stack.isEmpty()) {
                    while (counter > 0) {
                        result[index - 2] = '1';
                        result[index - 1] = '1';
                        result[index] = '0';
                        index -= 3;
                        counter--;
                    }
                } else {
                    byte n = stack.pop();

                    if (n == '0' && counter != 0) {
                        while (counter > 0) {
                            result[index - 2] = '1';
                            result[index - 1] = '1';
                            result[index] = '0';
                            index -= 3;
                            counter--;
                        }
                    }

                    result[index] = n;
                    index--;
                }
            }

            answer[r] = new String(result);
        }

        return answer;
    }
}
