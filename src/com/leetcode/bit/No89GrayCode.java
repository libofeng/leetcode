package com.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

public class No89GrayCode {
    public List<Integer> grayCode(int n) {
        final List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) list.add(list.get(j) | (1 << i));
        }

        return list;
    }
}
