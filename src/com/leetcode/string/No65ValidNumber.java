package com.leetcode.string;

public class No65ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean dotSeen = false, eSeen = false, digitSeen = false, digitAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digitSeen = true;
                digitAfterE = true;
            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (c == 'e') {
                if (eSeen || !digitSeen) return false;
                eSeen = true;
                digitAfterE = false;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }

        return digitSeen && digitAfterE;
    }
}
