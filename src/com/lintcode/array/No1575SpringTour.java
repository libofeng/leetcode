package com.lintcode.array;

public class No1575SpringTour {

    /**
     * @param a: The array a
     * @return: Return the minimum number of car
     */
    public int getAnswer(int[] a) {
        int total = 0;
        int[] count = new int[5];
        for (int n : a) count[n]++;

        total = count[4] + count[3] + count[2] / 2;
        count[1] -= count[3];
        count[2] %= 2;

        if (count[2] > 0) {
            count[1] -= 2;
            total++;
        }

        if (count[1] > 0) total += (count[1] + 3) / 4;
        return total;
    }
}
