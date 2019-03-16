package com.company.indeed;

public class DicePossibility {
    int dfs(int dice, int target) {
        int[][] vis = new int[6][6];
        if (vis[dice][target] != -1) return vis[dice][target];
        int ans = 0;
        if (dice == 0) {
            if (target == 0) ans = 1;
        } else if (dice * 6 >= target && target >= dice) {
            for (int i = 1; i <= 6; ++i) {
                if (target >= i)
                    ans += dfs(dice - 1, target - i);
            }
        }
        return vis[dice][target] = ans;
    }

    int dp(int dice, int target) {
        int[][] dp = new int[6][6];
        for (int i = 1; i <= 6; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= dice; ++i) {
            for (int j = i; j <= target; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if (j - k < i - 1) break; //target⼩小于骰⼦子个数 明显不不可能
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        return dp[dice][target];
    }
}
