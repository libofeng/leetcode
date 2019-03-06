package com.leetcode.array;

public class No443StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;

        int count = 1, index = 0;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) count++;
            else {
                chars[index++] = c;
                if (count > 1) {
                    for (char n : ("" + count).toCharArray()) chars[index++] = n;
                }

                count = 1;
                c = chars[i];
            }
        }
        chars[index++] = c;
        if (count > 1) {
            for (char n : ("" + count).toCharArray()) chars[index++] = n;
        }

        return index;
    }
}
