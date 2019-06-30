package com.leetcode.contest.contest143;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No1104PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        final LinkedList<Integer> list = new LinkedList<>();
        find(list, label);
        return list;
    }

    private void find(LinkedList<Integer> list, int label) {
        list.addFirst(label);
        if (label == 1) return;

        int i = 0, total = 0;
        while (pow2(i) + total < label) total += pow2(i++);

        label = total + (pow2(i) + total - label + 1);
        find(list, label / 2);
    }

    private int pow2(int i) {
        return (int) Math.pow(2, i);
    }

    public List<Integer> pathInZigZagTree2(int label) {
        int[] layStart = new int[21];
        int s = 1;
        int i = 0;
        while (i < 21 && s <= label) {
            layStart[i] = s;
            s *= 2;
            i++;
        }
        List<Integer> res = new ArrayList<>();
        while (i > 0) {
            i--;
            res.add(0, label);
            if (i == 0) {
                break;
            }
            label /= 2;
            label = layStart[i] + layStart[i - 1] - 1 - label;
        }
        return res;
    }
}
