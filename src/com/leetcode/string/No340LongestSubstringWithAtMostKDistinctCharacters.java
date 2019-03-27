package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No340LongestSubstringWithAtMostKDistinctCharacters {
    /*
    Given a string, find the length of the longest substring T that contains at most k distinct characters.

    Example 1:

    Input: s = "eceba", k = 2
    Output: 3
    Explanation: T is "ece" which its length is 3.


    Example 2:

    Input: s = "aa", k = 1
    Output: 2
    Explanation: T is "aa" which its length is 2.

     */

    int lengthOfLongestSubstringKDistinct(String s, int k) {
        final Map<Character, Integer> counter = new HashMap<>();

        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
            while (counter.size() > k) {
                c = s.charAt(start++);
                counter.put(c, counter.getOrDefault(c, 0) - 1);
                if (counter.get(c) == 0) counter.remove(c);
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    int lengthOfLongestSubstringKDistinct2(String s, int k) {
        final Map<Character, Integer> counter = new HashMap<>();

        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, i);
            while (counter.size() > k) {
                c = s.charAt(start);
                if (counter.get(c) == start) counter.remove(c);
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        No340LongestSubstringWithAtMostKDistinctCharacters solution = new No340LongestSubstringWithAtMostKDistinctCharacters();
        int maxLen = solution.lengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.println("passed = " + (maxLen == 3));

        maxLen = solution.lengthOfLongestSubstringKDistinct("aa", 1);
        System.out.println("passed = " + (maxLen == 2));

        maxLen = solution.lengthOfLongestSubstringKDistinct2("eceba", 2);
        System.out.println("passed = " + (maxLen == 3));

        maxLen = solution.lengthOfLongestSubstringKDistinct2("aa", 1);
        System.out.println("passed = " + (maxLen == 2));
    }
}
