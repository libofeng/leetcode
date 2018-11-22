package com.lintcode.array;

public class No645FindTheCelebrity {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) if (knows(candidate, i)) candidate = i;
        for (int i = 0; i < n; i++) {
            if (candidate != i && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }

        return candidate;
    }

    private boolean knows(int candidate, int i) {
        return false;
    }
}
