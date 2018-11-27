package com.lintcode;

public class No420CountAndSay {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder builder = new StringBuilder();
        String s = countAndSay(n - 1);

        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
            else {
                builder.append(count).append(c);
                count = 1;
                c = s.charAt(i);
            }
        }
        builder.append(count).append(c);

        return builder.toString();
    }
}
