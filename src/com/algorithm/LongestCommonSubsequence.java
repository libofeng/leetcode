package com.algorithm;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";

        int result = solution.lcs(str1, str2);
        System.out.println("result = " + result + ", expected:4");

        result = solution.lcs2(str1, str2);
        System.out.println("result = " + result + ", expected:4");
    }

    int lcs(String str1, String str2) {
        return lcs(str1, str1.length() - 1, str2, str2.length() - 1);
    }

    int lcs(String str1, int i, String str2, int j) {
        if (i < 0 || j < 0) return 0;

        if (str1.charAt(i) == str2.charAt(j)) return 1 + lcs(str1, i - 1, str2, j - 1);
        return Math.max(lcs(str1, i - 1, str2, j), lcs(str1, i, str2, j - 1));
    }

    int lcs2(String str1, String str2) {
        final int m = str1.length(), n = str2.length();
        final int[][] dp= new int[m+1][n+1];

        int max = 0;
        for(int i = 1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
