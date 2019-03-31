package com.leetcode.contest.contest130;

public class No1028ConvertToBaseNeg2 {
  /*  public String baseNeg2(int N) {
        if (N == 0) return "0";
        if (N == 1) return "1";

        return N % 2 == 1 ? (baseNeg2((N - 1) / -2) + "1") : (baseNeg2(N / -2) + "0");
    }*/


    public String baseNeg2(int N) {
        if (N == 0) return "0";

        int num = 0;
        int[] ans = new int[31];
        int max = 0;
        for (int i = 0; i < 31; i += 2) {
            if (num < N) {
                num += 1 << i;
                ans[i] = 1;
                max = i;
            }
        }
        for (int i = max - 1; i >= 0; --i) {
            if (num - (1 << i) >= N) {
                ans[i] = ans[i] ^ 1;
                num -= (1 << i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = max; i >= 0; --i) result.append(ans[i]);
        return result.toString();
    }
}
