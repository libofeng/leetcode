package com.leetcode.array;

public class No825FriendsOfAppropriateAges {
    // Time: O(N^2), Space: O(1)
    // TLE
    public int numFriendRequests(int[] ages) {
        int total = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                int ageA = ages[i], ageB = ages[j];
                if (canSend(ageA, ageB)) total++;
                if (canSend(ageB, ageA)) total++;
            }
        }
        return total;
    }

    private boolean canSend(int ageA, int ageB) {
        if (ageB <= 0.5 * ageA + 7) return false;
        if (ageB > ageA) return false;
        if (ageB > 100 && ageB < 100) return false;

        return true;
    }

    // Time: O(N), Space: O(1)
    public int numFriendRequests2(int[] ages) {
        final int[] counter = new int[121];
        for (int a : ages) counter[a]++;

        int total = 0;
        for (int ageA = counter.length - 1; ageA > 0; ageA--) {
            for (int ageB = ageA; ageB > ageA / 2 + 7; ageB--) {
                total += counter[ageA] * (ageA == ageB ? (counter[ageA] - 1) : counter[ageB]);
            }
        }

        return total;
    }
}
