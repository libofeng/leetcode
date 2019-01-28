package com.leetcode.string;

public class No44WildcardMatching {
    public boolean isMatch(String s, String p) {
        return isMath(s, 0, p, 0);
    }

    private boolean isMath(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();
        if (i == s.length()) return p.charAt(j) == '*' && isMath(s, i, p, j + 1);

        if (p.charAt(j) == '*') return isMath(s, i, p, j + 1) || isMath(s, i + 1, p, j + 1) || isMath(s, i + 1, p, j);
        else if (s.charAt(i) == p.charAt(j) || '?' == p.charAt(j)) return isMath(s, i + 1, p, j + 1);

        return false;
    }


    public boolean isMatch2(String s, String p) {
        final int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) dp[i][j] = dp[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        No44WildcardMatching solution = new No44WildcardMatching();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***";
        boolean matched = solution.isMatch(s, p);
        System.out.println("matched = " + matched);
    }
}
