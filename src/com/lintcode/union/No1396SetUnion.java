package com.lintcode.union;

import java.util.HashSet;
import java.util.Set;

public class No1396SetUnion {
    /**
     * @param sets: Initial set list
     * @return: The final number of sets
     */
    public int setUnion(int[][] sets) {
        int n = sets.length;
        UnionFind uf = new UnionFind(n);
        //Map<Integer, Integer> map = new HashMap<>(); // val -> set id
        Integer[] map = new Integer[100000 + 1];

        for (int i = 0; i < n; i++) {
            for (int val : sets[i]) {
                Integer id = map[val];
                if (id != null) {
                    uf.union(id, i);
                } else {
                    map[val] = i;
                }
            }
        }

        return uf.size();
    }
}

