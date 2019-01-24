package com.leetcode.string;

public class No387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] counter = new int[128];
        for (int i = 0; i < s.length(); i++) counter[s.charAt(i)]++;
        for (int i = 0; i < s.length(); i++) if (counter[s.charAt(i)] == 1) return i;
        return -1;
    }
}
