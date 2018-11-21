package com.lintcode.string;

import java.util.Arrays;

public class No720RearrangeAStringWithIntegers {
    /**
     * @param str: a string containing uppercase alphabets and integer digits
     * @return: the alphabets in the order followed by the sum of digits
     */
    // Time: O(N), Space: O(N)
    public String rearrange(String str) {
        if (str == null || str.length() == 0) return str;
        int[] counter = new int[26];

        int sum = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) counter[c - 'A']++;
            else sum += (c - '0');
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                builder.append((char) (i + 'A'));
            }
        }
        builder.append(sum);

        return builder.toString();
    }


    // Time: O(N*LogN), Space: O(N)
    public String rearrange2(String str) {
        if(str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int i = 0, sum = 0;
        for(; i<chars.length; i++) {
            if(Character.isDigit(chars[i])) sum += (chars[i] - '0');
            else break;
        }
        return (new String(chars)).substring(i) + sum;
    }
}
