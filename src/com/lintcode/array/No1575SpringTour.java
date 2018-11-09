package com.lintcode.array;

public class No1575SpringTour {

    /**
     * @param a: The array a
     * @return: Return the minimum number of car
     */
    public int getAnswer(int[] a) {
        int[] num = new int[5];
        for (int n : a) num[n]++;

        int cars = num[4] + num[3] + num[2] / 2;
        num[1] -= num[3];
        num[2] %= 2;

        if (num[2] > 0) {
            num[1] -= 2;
            cars++;
        }

        if (num[1] > 0) cars += (num[1] + 3) / 4;
        return cars;
    }
}
