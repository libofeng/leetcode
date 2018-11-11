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
}
