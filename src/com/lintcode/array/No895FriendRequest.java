package com.lintcode.array;

public class No895FriendRequest {
    /**
     * @param ages: The ages
     * @return: The answer
     */
    public int friendRequest(int[] ages) {
        int total = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (canSend(ages[i], ages[j])) total++;
                if (canSend(ages[j], ages[i])) total++;
            }
        }

        return total;
    }

    private boolean canSend(int A, int B) {
        if (B <= A / 2 + 7) return false;
        if (B > A) return false;
        if (B < 100 && A > 100) return false;

        return true;
    }

}
