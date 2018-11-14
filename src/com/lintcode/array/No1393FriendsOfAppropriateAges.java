package com.lintcode.array;

public class No1393FriendsOfAppropriateAges {
    /**
     * @param ages:
     * @return: nothing
     */
    public int numFriendRequests(int[] ages) {
        final int[] c = new int[121];
        for (int age : ages) c[age]++;

        int total = 0;
        for (int i = c.length - 1; i > 0; i--) {
            for (int j = i; j > i / 2 + 7; j--) total += c[i] * (i == j ? c[i] - 1 : c[j]);
        }

        return total;
    }

    // Brute force, timeout
    public int numFriendRequests2(int[] ages) {
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (allow(ages[i], ages[j])) count++;
                if (allow(ages[j], ages[i])) count++;
            }
        }

        return count;
    }

    private boolean allow(int A, int B) {
        if (B <= A * 0.5 + 7 || B > A || B > 100 && A < 100 ) return false;
        return true;
    }
}
