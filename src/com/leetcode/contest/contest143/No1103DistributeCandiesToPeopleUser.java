package com.leetcode.contest.contest143;

public class No1103DistributeCandiesToPeopleUser {
    public int[] distributeCandies(int candies, int num_people) {
        final int[] result = new int[num_people];
        int sum = (1 + num_people) * num_people / 2;

        int index = 0, c = 1;
        while (candies > 0) {
            result[index] += Math.min(c, candies);
            candies -= c++;
            if (++index >= num_people) index %= num_people;
        }

        return result;
    }
}
