package com.lintcode.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No401BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= 60; i++) {
            int bitCount = Integer.bitCount(i);
            map.putIfAbsent(bitCount, new ArrayList<>());
            map.get(bitCount).add(i);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (i >= 4 || num - i >= 6) continue;

            List<Integer> hours = map.get(i), minutes = map.get(num - i);
            for (int h : hours) {
                if (h >= 12) continue;
                for (int m : minutes) {
                    if (m >= 60) continue;
                    result.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }

        return result;
    }
}
