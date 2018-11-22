package com.lintcode.dp;

public class No1574MusicPlaylist {
    /**
     * @param n: the number of on his mobile phone
     * @param m: in the middle of two songs, there are at least m other songs
     * @param p: the number of songs he can listen to
     * @return: the number of playlists
     */
    public int getAns(int n, int m, int p) {
        final long MOD = 1000000007L;

        long[][] dp = new long[p + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * (n - j + 1) % MOD) % MOD;
                if (j > m) dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - m) % MOD) % MOD;
            }
        }
        return (int) dp[p][n];
    }
}
