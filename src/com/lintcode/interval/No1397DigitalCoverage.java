package com.lintcode.interval;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class No1397DigitalCoverage {

    /**
     * @param intervals: The intervals
     * @return: The answer
     */
    public int digitalCoverage(List<Interval> intervals) {
        final int[] count = new int[100001];

        int max = 0;
        for (Interval interval : intervals) {
            for (int i = interval.start; i <= interval.end; i++) {
                count[i]++;
                max = Math.max(max, count[i]);
            }
        }

        for (int i = 0; i < count.length; i++) if (count[i] == max) return i;

        return 0;
    }

    // https://www.lintcode.com/problem/digital-coverage/note/145168
    public int digitalCoverage2(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end + 1, map.getOrDefault(i.end + 1, 0) - 1);
        }

        int cnt = 0;
        int maxCnt = 0;
        int num = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            cnt += e.getValue();
            if (maxCnt < cnt) {
                maxCnt = cnt;
                num = e.getKey();
            }

        }

        return num;
    }
}
