package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class No159LongestSubstringWithAtMostTwoDistinctCharacters {
    /*
    Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

    Example 1:

    Input: "eceba"
    Output: 3
    Explanation: t is "ece" which its length is 3.
    Example 2:

    Input: "ccaabbb"
    Output: 5
    Explanation: t is "aabbb" which its length is 5.
     */

    int findMaxLen(String s, int n) {
        final int[] counter = new int[26];

        int start = 0, maxLen = 0, distinct = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counter[c - 'a']++ == 0) distinct++;
            while (distinct > n) if (--counter[s.charAt(start++) - 'a'] == 0) distinct--;
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }


    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        int start = -1, maxLen = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.size()==2 && !map.containsKey(c)){

                int next = s.length();
                char keyToRemove = 0;
                for(char key : map.keySet()){
                    if(map.get(key)<next){
                        next = map.get(key);
                        keyToRemove = key;
                    }
                }
                map.remove(keyToRemove);
                start = next;
            }
            map.put(c, i);

            maxLen = Math.max(maxLen, i - start);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        No159LongestSubstringWithAtMostTwoDistinctCharacters solution = new No159LongestSubstringWithAtMostTwoDistinctCharacters();
        int maxLen = solution.findMaxLen("eceba", 2);
        System.out.println("maxLen==3? " + (maxLen == 3));

        maxLen = solution.findMaxLen("ccaabbb", 2);
        System.out.println("maxLen==5? " + (maxLen == 5));
    }
}
