package com.lintcode.string;

public class No719CalculateMaximumValue {
    /**
     * @param str: the given string
     * @return: the maximum value
     */
    // DP
    public int calcMaxValue(String str) {
        int[] R = new int[str.length()+1];
        for(int i = 1;i<R.length;i++) {
            R[i] = Math.max(R[i-1] + str.charAt(i-1) - '0', R[i-1] * (str.charAt(i-1) - '0'));
        }
        return R[R.length - 1];
    }

    // DP, simplified
    public int calcMaxValue2(String str) {
        int R = 0;
        for (char c : str.toCharArray()) R = Math.max(R + (c - '0'), R * (c - '0'));

        return R;
    }
}
