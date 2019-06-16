package com.algorithm;

public class LongestCommonSubsequence2 {
    public static void main(String[] args) {
        LongestCommonSubsequence2 solution = new LongestCommonSubsequence2();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";

        String result = solution.lcs(str1, str2);
        System.out.println("result = " + result + ", expected:ADHR");

        result = solution.lcs2(str1, str2);
        System.out.println("result = " + result + ", expected:ADHR");
    }

    String lcs(String str1, String str2) {
        return lcs(str1, str1.length() - 1, str2, str2.length() - 1);
    }

    String lcs(String str1, int i, String str2, int j) {
        if (i < 0 || j < 0) return "";

        if (str1.charAt(i) == str2.charAt(j)) return lcs(str1, i - 1, str2, j - 1) + str2.charAt(j);
        String lcs1 = lcs(str1, i - 1, str2, j), lcs2 = lcs(str1, i, str2, j - 1);
        return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
    }

    String lcs2(String str1, String str2) {
        final int m = str1.length(), n = str2.length();
        final int[][] dp = new int[m + 1][n + 1];

        int max = 0, x = 0, y = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (dp[i][j] > max) {
                    max = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (x > 0 && y > 0) {
            if (dp[x][y] == dp[x - 1][y]) x--;
            else if (dp[x][y] == dp[x][y - 1]) y--;
            else {
                sb.append(str1.charAt(x-1));
                x--;
                y--;
            }
        }

        return sb.reverse().toString();
    }
}
