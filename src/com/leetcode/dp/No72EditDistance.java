package com.leetcode.dp;

public class No72EditDistance {
//    设状态为f[i][j]，表示A[0,i]和B[0,j]之间的最小编辑距离。设A[0,i]的形式是str1c，B[0,j]的形式是str2d，
//    如果c==d，则f[i][j]=f[i-1][j-1]；
//    如果c!=d，
//    如果将c替换成d，则f[i][j]=f[i-1][j-1]+1；
//    如果在c后面添加一个d，则f[i][j]=f[i][j-1]+1；
//    如果将c删除，则f[i][j]=f[i-1][j]+1；

    public int minDistance(String word1, String word2) {
        final int m = word1.length(), n = word2.length();
        final int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    // one edit: replace, remove, add
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[m][n];
    }
}
