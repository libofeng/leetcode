package com.lintcode.dp;

public class No1586MinimumNumberOfKeystrokes {
    /**
     * @param s: the English word
     * @return: The number of keystrokes
     */
    public int getAns(String s) {
        int[][] dp = new int[s.length() + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + 2, dp[i - 1][0] + (Character.isUpperCase(s.charAt(i - 1)) ? 2 : 1));
            dp[i][1] = Math.min(dp[i - 1][0] + 2, dp[i - 1][1] + (Character.isLowerCase(s.charAt(i - 1)) ? 2 : 1));
        }

        return Math.min(dp[s.length()][0], dp[s.length()][1]);
    }

    public int getAns2(String s) {
        int c1 = 0, c2 = 1;
        for (int i = 1; i <= s.length(); i++) {
            int tmp = c1;
            c1 = Math.min(c2 + 2, c1 + (Character.isUpperCase(s.charAt(i - 1)) ? 2 : 1));
            c2 = Math.min(tmp + 2, c2 + (Character.isLowerCase(s.charAt(i - 1)) ? 2 : 1));
        }

        return Math.min(c1, c2);
    }


}
