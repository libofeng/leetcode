package com.leetcode.string;

public class No383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        final int[] counter = new int[128];
        for (int i = 0; i < magazine.length(); i++) counter[magazine.charAt(i)]++;
        for (int i = 0; i < ransomNote.length(); i++) if (--counter[ransomNote.charAt(i)] < 0) return false;
        return true;
    }
}
