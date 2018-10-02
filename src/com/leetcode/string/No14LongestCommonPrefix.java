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

        for (int j = 0; j < strs[0].length(); ++j) {
            for (int i = 1; i < strs.length; ++i) {
                if (j == strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }
}
