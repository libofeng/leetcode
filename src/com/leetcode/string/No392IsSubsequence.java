package com.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class No392IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char a = s.charAt(i), b = t.charAt(j);
            if (a == b) i++;
            j++;
        }

        return i == s.length();
    }

    // The difference is that indexOf only call once function then traversed in "String.value[]" arr, but we used multiple calling function "charAt" to get the value in "String.value[]" arr.
    // *The time expense of calling function made the difference.*
    public boolean isSubsequence2(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char c = s.charAt(i);
            int index = t.indexOf(c, j);
            if (index < 0) return false;

            j = index + 1;
            i++;
        }

        return i == s.length();
    }

    // for follow-up
    public boolean isSubsequence3(String s, String t) {
        final TreeSet<Integer>[] list = new TreeSet[256];
        for (int i = 0; i < t.length(); i++) {
            if (list[t.charAt(i)] == null) list[t.charAt(i)] = new TreeSet<>();
            list[t.charAt(i)].add(i);
        }

        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list[c] == null) return false;
            Integer index = list[c].ceiling(startIndex);
            if (index == null) return false;

            startIndex = index + 1;
        }

        return true;
    }

    // for follow-up
    public boolean isSubsequence4(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}
