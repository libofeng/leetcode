package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No271EncodeAndDecodeStrings {
    // https://www.cnblogs.com/airwindow/p/4799854.html
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s.length()).append(":").append(s);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        final List<String> result = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int index = s.indexOf(":", start);
            int len = Integer.parseInt(s.substring(start, index));
            result.add(s.substring(index + 1, index + len + 1));
            start = index + len + 1;
        }

        return result;
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
