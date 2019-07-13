package com.leetcode.string;

public class No420StrongPasswordChecker {
    // https://leetcode.com/problems/strong-password-checker/discuss/91003/O(n)-java-solution-by-analyzing-changes-allowed-to-fix-each-problem
    // https://www.cnblogs.com/grandyang/p/5988792.html
    public int strongPasswordChecker(String s) {
        final int n = s.length();
        int missingL = 1, missingU = 1, missingD = 1;
        final char[] chars = s.toCharArray();
        final int[] count = new int[n];

        for (int i = 0; i < n; ) {
            if (Character.isLowerCase(chars[i])) missingL = 0;
            if (Character.isUpperCase(chars[i])) missingU = 0;
            if (Character.isDigit(chars[i])) missingD = 0;

            int j = i;
            while (i < n && chars[i] == chars[j]) i++;
            count[j] = i - j;
        }

        int totalMissing = missingL + missingU + missingD;
        if (n < 6) return totalMissing + Math.max(0, 6 - (n + totalMissing));

        int overMax = Math.max(n - 20, 0), overMaxLeft = 0, changes = 0;
        changes += overMax;

        for (int k = 1; k < 3; k++) {
            for (int i = 0; i < n && overMax > 0; i++) {
                if (count[i] < 3 || count[i] % 3 != (k - 1)) continue;
                count[i] -= Math.min(overMax, k);
                overMax -= k;
            }
        }

        for (int i = 0; i < n; i++) {
            if (count[i] >= 3 && overMax > 0) {
                int need = count[i] - 2;
                count[i] -= overMax;
                overMax -= need;
            }

            if (count[i] >= 3) overMaxLeft += count[i] / 3;
        }

        changes += Math.max(totalMissing, overMaxLeft);
        return changes;
    }
}
