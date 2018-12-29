package com.leetcode.string;

public class No385MiniParser {
    int i = 0;

    public NestedInteger deserialize(String s) {
        if (i >= s.length()) return new NestedInteger();

        NestedInteger ni = new NestedInteger();
        if (s.charAt(i) == '[') {
            i++; //skip '['

            while (i < s.length() && s.charAt(i) != ']') {
                if (s.charAt(i) == '-' || Character.isDigit(s.charAt(i))) {
                    ni.add(new NestedInteger(nextNum(s)));
                }

                if (s.charAt(i) == '[') ni.add(deserialize(s));
            }

            i++; //skip ']'
            if (i < s.length() && s.charAt(i) == ',') i++;

        } else ni.setInteger(nextNum(s));

        return ni;
    }

    private Integer nextNum(String s) {
        int num = 0, sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }

        if (i < s.length() && s.charAt(i) == ',') i++;
        return num * sign;
    }
}
