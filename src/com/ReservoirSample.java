package com;

import java.util.Random;

public class ReservoirSample {
    // https://blog.csdn.net/Yaokai_AssultMaster/article/details/78850698
    public int[] reservoirSample(int[] input, int k) {
        int n = input.length;
        int[] ret = new int[k];
        for (int i = 0; i < n; i++) {
            if (i < k) {
                ret[i] = input[i];
            } else {
                int rand = new Random().nextInt(i);
                if (rand < k) {
                    ret[rand] = input[i];
                }
            }
        }

        return ret;
    }
}
