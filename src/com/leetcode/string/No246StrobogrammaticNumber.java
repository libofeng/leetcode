package com.leetcode.string;

public class No246StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int lo = 0, hi = num.length() - 1;
        while (lo <= hi) if (!isStrobogrammatic(num.charAt(lo++), num.charAt(hi--))) return false;
        return true;
    }

    private boolean isStrobogrammatic(char c1, char c2) {
        switch (c1) {
            case '0':
                return c2 == '0';

            case '1':
                return c2 == '1';

            case '8':
                return c2 == '8';

            case '6':
                return c2 == '9';

            case '9':
                return c2 == '6';
        }

        return false;
    }
}
