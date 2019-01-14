package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No438FindAllAnagramsInAString {
    public List<Integer> findAnagrams0(String s, String p) {
        List<Integer> R = new ArrayList<>();

        char[] pchars = p.toCharArray();
        Arrays.sort(pchars);
        p = new String(pchars);

        for (int i = 0; i <= s.length() - pchars.length; i++) {
            char[] schars = s.substring(i, i + pchars.length).toCharArray();
            Arrays.sort(schars);
            if ((new String(schars)).equals(p)) R.add(i);
        }

        return R;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> R = new ArrayList<>();
        if (s.length() < p.length()) return R;

        int[] countS = new int[256], countP = new int[256];
        int i;
        for (i = 0; i < p.length(); i++) {
            countS[s.charAt(i)]++;
            countP[p.charAt(i)]++;
        }
        if (Arrays.equals(countS, countP)) R.add(0);

        for (i = p.length(); i < s.length(); i++) {
            countS[s.charAt(i - p.length())]--;
            countS[s.charAt(i)]++;
            if (Arrays.equals(countS, countP)) R.add(i - p.length() + 1);
        }

        return R;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> R = new ArrayList<>();
        int[] count = new int[256];
        for (char c : p.toCharArray()) count[c]++;

        int left = 0, right = 0, diff = p.length();
        while (right < s.length()) {
            if (count[s.charAt(right++)]-- >= 1) diff--;
            if (diff == 0) R.add(left);
            if (right - left == p.length() && count[s.charAt(left++)]++ >= 0) diff++;
        }

        return R;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;

        int[] count = new int[26];

        int diff = p.length(), start = 0;
        for (int i = 0; i < p.length(); i++) count[p.charAt(i) - 'a']++;
        for (int i = 0; i < p.length() - 1; i++) if (count[s.charAt(i) - 'a']-- > 0) diff--;

        for (int i = p.length() - 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a']-- > 0 && --diff == 0) list.add(start);
            if (count[s.charAt(start++) - 'a']++ >= 0) diff++;
        }

        return list;
    }
}

