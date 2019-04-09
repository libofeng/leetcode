package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No271EncodeAndDecodeStrings {
    // https://www.cnblogs.com/airwindow/p/4799854.html

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) return null;

        final StringBuilder sb = new StringBuilder();
        for (String str : strs) sb.append(str.length()).append(":").append(str);

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) return null;

        final List<String> strs = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < s.length()) {
            int index = s.indexOf(":", startIndex);
            int len = Integer.parseInt(s.substring(startIndex, index));
            strs.add(s.substring(index + 1, index + 1 + len));
            startIndex = index + 1 + len;
        }

        return strs;
    }

    public static void main(String[] args) {
        final List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("def");
        strs.add("h:i:j:k");
        No271EncodeAndDecodeStrings solution = new No271EncodeAndDecodeStrings();
        String encoded = solution.encode(strs);
        final List<String> decoded = solution.decode(encoded);
        System.out.println("decoded = " + decoded);
    }
}
