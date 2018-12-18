package com.lintcode.string;

public class No192WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();
        if (i == s.length()) return j == p.length() || (p.charAt(j) == '*' && isMatch(s, i, p, j + 1));

        if (p.charAt(j) == '*') {
            return isMatch(s, i, p, j + 1) || isMatch(s, i + 1, p, j + 1) || isMatch(s, i + 1, p, j);
        } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            return isMatch(s, i + 1, p, j + 1);
        }

        return false;
    }

    // DP
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) if (p.charAt(i - 1) == '*') dp[i][0] |= dp[i - 1][0];

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] |= dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] |= dp[i - 1][j - 1] | dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        No192WildcardMatching solution = new No192WildcardMatching();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        boolean matched = solution.isMatch(s, p);
        System.out.println("matched = " + matched);
    }
}
