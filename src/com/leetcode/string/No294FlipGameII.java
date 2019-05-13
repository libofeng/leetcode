package com.leetcode.string;

public class No294FlipGameII {
    public static void main(String[] args) {
        No294FlipGameII solution = new No294FlipGameII();
        boolean result = solution.canWin("++++");

        System.out.println("result = " + result);
    }

    // https://leetcode.com/problems/flip-game-ii/discuss/73954/Theory-matters-from-Backtracking(128ms)-to-DP-(0ms)
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }

    private boolean canWin(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';

                boolean otherWin = canWin(chars);
                chars[i] = '+';
                chars[i + 1] = '+';

                if (!otherWin) return true;
            }
        }

        return false;
    }
}
