package com.leetcode.string;

public class No248StrobogrammaticNumberIII {
    int total;

    public int strobogrammaticInRange(String low, String high) {
        find(low, high, "");
        find(low, high, "0");
        find(low, high, "1");
        find(low, high, "8");
        return total;
    }

    private void find(String low, String high, String w) {
        if (w.length() >= low.length() && w.length() <= high.length()) {
            if ((w.length() == low.length() && w.compareTo(low) < 0)
                    || (w.length() == high.length() && w.compareTo(high) > 0)) return;

            if (w.length() > 1 && w.charAt(0) != '0') total++;
        }

        if (w.length() + 2 > high.length()) return;
        find(low, high, '0' + w + '0');
        find(low, high, '1' + w + '1');
        find(low, high, '6' + w + '6');
        find(low, high, '8' + w + '8');
        find(low, high, '9' + w + '6');
    }

    public static void main(String[] args) {
        No248StrobogrammaticNumberIII solution = new No248StrobogrammaticNumberIII();
        int total = solution.strobogrammaticInRange("50", "100");
        System.out.println("total = " + total);
    }
}
