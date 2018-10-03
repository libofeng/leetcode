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
}

