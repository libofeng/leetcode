package com.leetcode.contest.contest149;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No1156SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        Map<Character, List<Seg>> segMap = buildSegmentMap(text);

        int maxLen = 0;
        for (Map.Entry<Character, List<Seg>> e : segMap.entrySet()) {
            List<Seg> list = e.getValue();

            for (int i = 0; i < list.size(); i++) {
                maxLen = Math.max(maxLen, list.get(i).e - list.get(i).s + (list.size() > 1 ? 2 : 1));
                if (i == list.size() - 1) continue;

                // split by a different char
                if (list.get(i).e + 2 == list.get(i + 1).s) {
                    if (list.size() == 2) maxLen = Math.max(maxLen, list.get(i + 1).e - list.get(i).s);
                    else maxLen = Math.max(maxLen, list.get(i + 1).e - list.get(i).s + 1);
                }
            }
        }

        return maxLen;
    }

    private Map<Character, List<Seg>> buildSegmentMap(String text) {
        int N = text.length();

        Map<Character, List<Seg>> segMap = new HashMap<>();
        int s = 0;
        for (int i = 0; i < N; i++) {
            if (text.charAt(i) != text.charAt(s)) {
                char c = text.charAt(s);
                segMap.putIfAbsent(c, new ArrayList<>());
                segMap.get(c).add(new Seg(s, i - 1, c));
                s = i;
            }
        }
        char c = text.charAt(s);
        segMap.putIfAbsent(text.charAt(s), new ArrayList<>());
        segMap.get(c).add(new Seg(s, N - 1, c));

        return segMap;
    }

    public int maxRepOpt12(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[chs[i] - 'a']++;

        int p1 = 0, ans = 0;
        while (p1 < n) {
            char base = chs[p1];
            int diff = -1, p2 = p1 + 1;
            while (p2 < n && (base == chs[p2] || diff < 0)) {
                if (base != chs[p2]) {
                    ans = Math.max(ans, p2 - p1);
                    diff = p2;
                }
                p2++;
            }
            if (diff < 0 || count[base - 'a'] > p2 - p1 - 1) {
                ans = Math.max(ans, p2 - p1);
            } else {
                ans = Math.max(ans, p2 - p1 - 1);
            }
            if (diff < 0) p1 = p2;
            else p1 = diff;
        }
        return ans;
    }

    class Seg {
        int s;
        int e;
        char v;

        Seg(int s, int e, char v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}
