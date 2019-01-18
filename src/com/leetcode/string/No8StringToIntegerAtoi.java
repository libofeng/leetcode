package com.leetcode.string;

public class No8StringToIntegerAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int len = str.length();

        boolean minus = false;
        //find valid start
        int i = 0;
        for (; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '-') {
                minus = true;
                i++;
                break;
            } else if (c == '+') {
                i++;
                break;
            } else if (c >= '0' && c <= '9') {
                break;
            } else {
                return 0;
            }
        }


        int number = 0;
        for (int j = i; j < len; j++) {
            char c = str.charAt(j);

            if (c < '0' || c > '9') break;// invalid
            if (number >= (Integer.MAX_VALUE - (c - '0')) / 10) {
                if (minus) {
                    if (number == (Integer.MAX_VALUE - (c - '0')) / 10) {
                        return -Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                number = number * 10 + (c - '0');
            }
        }

        return minus ? -number : number;
    }


    public int myAtoi2(String str) {
        int sign = 1;
        long num = 0;
        boolean signFound = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ') {
                if (signFound) break;
            } else if (c == '+' || c == '-') {
                if (signFound) break;
                signFound = true;
                if (c == '-') sign = -1;
            } else if (Character.isDigit(c)) {
                signFound = true;

                num = num * 10 + (c - '0') * sign;
                if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else break;
        }

        return (int) num;
    }
}
