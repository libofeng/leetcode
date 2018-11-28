package com.lintcode;

public class No74FirstBadVersion {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (SVNRepo.isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private static class SVNRepo {
        static boolean isBadVersion(int mid) {
            return false;
        }
    }
}
