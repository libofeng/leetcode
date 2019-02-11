package com.leetcode.string;

public class No14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int commonLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int j;
            for (j = 0; j < commonLen && j < strs[i].length(); j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) break;
            }

            commonLen = j;
        }

        return strs[0].substring(0, commonLen);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";

        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || str.charAt(i) != s.charAt(i)) return s.substring(0, i);
            }
        }

        return s;
    }
}
