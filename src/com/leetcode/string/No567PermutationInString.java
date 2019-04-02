package com.leetcode.string;

import java.util.Arrays;

public class No567PermutationInString {

    // Time: O(NMLogM), Space: O(M)
    public boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);

        for (int i = s1.length(); i <= s2.length(); i++) {
            char[] chars2 = s2.substring(i - s1.length(), i).toCharArray();
            Arrays.sort(chars2);
            if (Arrays.equals(chars1, chars2)) return true;
        }

        return false;
    }


    // Time: O(N), Space: O(M)
    public boolean checkInclusion2(String s1, String s2) {
        final int[] c1 = new int[26], c2 = new int[26];
        final int len1 = s1.length(), len2 = s2.length();

        for (int i = 0; i < len1; i++) c1[s1.charAt(i) - 'a']++;

        int start = 0;
        for (int i = 0; i < len2; i++) {
            c2[s2.charAt(i) - 'a']++;
            if (i - start + 1 == len1) {
                if (Arrays.equals(c1, c2)) return true;
                c2[s2.charAt(start++) - 'a']--;
            }
        }

        return false;
    }
}
