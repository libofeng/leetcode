package com.leetcode.array;

public class No771JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[128];
        for (int i = 0; i < J.length(); i++) jewels[J.charAt(i)] = true;

        int count = 0;
        for (int i = 0; i < S.length(); i++) if (jewels[S.charAt(i)]) count++;
        return count;
    }
}
