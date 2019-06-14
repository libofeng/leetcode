package com.leetcode.array;

import java.util.Random;
import java.util.TreeMap;

public class No528RandomPickWithWeightBIT {


    private Random rnd = new Random();
    private BIT bit;
    private int n;

    public No528RandomPickWithWeightBIT(int[] w) {
        bit = new BIT(w);
        n = w.length;
    }

    public int pickIndex() {
        int sum = rnd.nextInt(bit.query(n - 1)) + 1;

        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2, midSum = bit.query(mid), leftMidSum = bit.query(mid - 1);
            if (sum > leftMidSum && sum <= midSum) return mid;

            if (sum > midSum) lo = mid + 1;
            else hi = mid - 1;
        }

        return lo;
    }

    class BIT {
        int[] w, bit;

        BIT(int[] w) {
            this.w = w;
            this.bit = new int[w.length + 1];

            for (int i = 0; i < w.length; i++) set(i, w[i]);
        }

        void set(int i, int val) {
            for (i++; i < bit.length; i += (i & -i)) bit[i] += val;
        }

        int query(int i) {
            int sum = 0;
            for (i++; i > 0; i -= (i & -i)) sum += bit[i];
            return sum;
        }

        void update(int i, int val) {
            int delta = val - w[i];
            w[i] = val;

            set(i, val);
        }
    }
}
