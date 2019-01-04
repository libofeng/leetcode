package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No763PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        Set<Character> set = new HashSet<>();

        int len = 0;
        List<Integer> list = new ArrayList<>();
        for (char c : S.toCharArray()) {
            len++;

            if (--count[c - 'a'] == 0) {
                set.remove(c);
                if (set.size() == 0) {
                    list.add(len);
                    len = 0;
                }
            } else set.add(c);
        }

        return list;
    }

    public List<Integer> partitionLabels2(String S) {
        List<Integer> list = new ArrayList<>();

        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) count[S.charAt(i) - 'a']++;

        Set<Character> set = new HashSet<>();
        int total = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.add(S.charAt(i))) total += count[S.charAt(i) - 'a'];
            if (total == (i - start + 1)) {
                start = i + 1;
                list.add(total);
                total = 0;
            }
        }

        return list;
    }

    public List<Integer> partitionLabels3(String S) {
        if (S == null || S.length() == 0) return null;
        List<Integer> list = new ArrayList<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < S.length(); i++) lastIndex[S.charAt(i) - 'a'] = i;

        int last = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);

            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }

        return list;
    }

}
