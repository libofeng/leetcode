package com.leetcode.contest.biweekly.contest4;

public class No1119RemoveVowelsFromAString {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
