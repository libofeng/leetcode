package com.leetcode.string;

public class No44WildcardMatching {
    // TLE
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) return p.charAt(0) == '*' && isMatch(s, p.substring(1));

        boolean firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '?';
        if (firstMatch) return isMatch(s.substring(1), p.substring(1));
        else if (p.charAt(0) == '*') return isMatch(s, p.substring(1))
                || isMatch(s.substring(1), p.substring(1))
                || isMatch(s.substring(1), p);

        return false;
    }

    // TLE
    public boolean isMatch2(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();
        if (i == s.length()) return p.charAt(j) == '*' && isMatch(s, i, p, j + 1);

        boolean firstMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '?';
        if (firstMatch) return isMatch(s, i + 1, p, j + 1);
        else if (p.charAt(j) == '*') return isMatch(s, i + 1, p, j + 1)
                || isMatch(s, i, p, j + 1)
                || isMatch(s, i + 1, p, j);

        return false;
    }


    public boolean isMatch3(String s, String p) {
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
        boolean matched = solution.isMatch2(s, p);
        System.out.println("matched = " + matched);

        s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        p = "***bba**a*bbba**aab**b";
        matched = solution.isMatch2(s, p);
        System.out.println("matched = " + matched);
    }
}
