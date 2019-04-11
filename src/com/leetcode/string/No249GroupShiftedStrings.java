package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No249GroupShiftedStrings {
    /*
    Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

    "abc" -> "bcd" -> ... -> "xyz"
    Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

    Example:

    Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
    Output:
    [
      ["abc","bcd","xyz"],
      ["az","ba"],
      ["acef"],
      ["a","z"]
    ]
     */

    // https://blog.csdn.net/laserljy123/article/details/56390981
    public List<List<String>> groupStrings(String[] strings) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) map.computeIfAbsent(getKey(s), k -> new ArrayList<>()).add(s);

        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        final int total = 26;
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int gap = (total + (s.charAt(i) - s.charAt(i - 1))) % total;
            sb.append(gap).append(",");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final String[] input = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        No249GroupShiftedStrings solution = new No249GroupShiftedStrings();
        List<List<String>> result = solution.groupStrings(input);
        System.out.println("result = " + result);
    }
}
