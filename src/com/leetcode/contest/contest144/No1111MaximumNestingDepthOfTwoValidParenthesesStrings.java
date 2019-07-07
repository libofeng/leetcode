package com.leetcode.contest.contest144;

public class No1111MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        final int[] result = new int[seq.length()];
        for (int i = 0, left = 0; i < seq.length(); i++) {
            result[i] = seq.charAt(i) == '(' ? ++left % 2 : left-- % 2;
        }

        return result;
    }
}
