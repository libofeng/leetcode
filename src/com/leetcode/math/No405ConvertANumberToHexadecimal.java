package com.leetcode.math;

public class No405ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";

        final char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final StringBuilder sb = new StringBuilder();
        do {
            sb.append(map[15 & num]);
            num >>>= 4;
        } while (num != 0);

        return sb.reverse().toString();
    }
}
