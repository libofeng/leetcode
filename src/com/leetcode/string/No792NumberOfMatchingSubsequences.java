package com.leetcode.string;

import java.text.StringCharacterIterator;
import java.util.*;

public class No792NumberOfMatchingSubsequences {
    // Brute force:
    // Time complexity: O(S * W * L）
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String w : words) if (isSubsequence(S, w)) count++;

        return count;
    }

    private boolean isSubsequence(String s, String w) {
        int si = 0, wi = 0;
        while (si < s.length() && wi < w.length()) {
            if (s.charAt(si) == w.charAt(wi)) {
                si++;
                wi++;
            } else si++;
        }

        return wi == w.length();
    }

    // Time complexity: O(S * W * L）
    public int numMatchingSubseq2(String S, String[] words) {
        final Map<Character, Queue<String>> map = new HashMap<>();
        for (String w : words) map.computeIfAbsent(w.charAt(0), k -> new LinkedList<>()).add(w);

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            Queue<String> dq = map.get(c);
            int size = dq == null ? 0 : dq.size();

            while (size-- > 0) {
                String w = dq.poll();
                if (w.length() == 1) count++;
                else map.computeIfAbsent(w.charAt(1), k -> new LinkedList<>()).add(w.substring(1));
            }
        }

        return count;
    }

    // https://leetcode.com/problems/number-of-matching-subsequences/discuss/117634/Efficient-and-simple-go-through-words-in-parallel-with-explanation
    public int numMatchingSubseq3(String S, String[] words) {
        List<StringCharacterIterator>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList();
        for (String w : words)
            waiting[w.charAt(0)].add(new StringCharacterIterator(w));
        for (char c : S.toCharArray()) {
            List<StringCharacterIterator> advance = waiting[c];
            waiting[c] = new ArrayList();
            for (StringCharacterIterator it : advance)
                waiting[it.next() % it.DONE].add(it);
        }
        return waiting[0].size();
    }
}
