package com.leetcode.string;

public class No65ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false, eSeen = false, numberSeen = false, numberAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

}
