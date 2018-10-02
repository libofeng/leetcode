package com.leetcode.string;

public class No38CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String say = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();

        char c = say.charAt(0);
        int count = 0;
        for (int i = 0; i < say.length(); i++) {
            if (say.charAt(i) == c) count++;
            else {
                builder.append(count).append(c);
                c = say.charAt(i);
                count = 1;
            }
        }
        builder.append(count).append(c);

        return builder.toString();
    }
}
