package com.lintcode.list;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class No821TimeIntersection {

    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    // Time complexity: O((A + B)),  Space complexity: O(A+B) OR O(1)
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        int i = 0, j = 0;
        final List<Interval> R = new LinkedList<>();
        while (i < seqA.size() && j < seqB.size()) {
            Interval A = seqA.get(i), B = seqB.get(j);
            if (A.end < B.start) i++;
            else if (B.end < A.start) j++;
            else {
                int start = Math.max(A.start, B.start);
                int end = Math.min(A.end, B.end);
                R.add(new Interval(start, end));

                if (A.end > end) j++;
                else if (B.end > end) i++;
                else {
                    i++;
                    j++;
                }
            }
        }

        return R;
    }

    // Sweep line. Time complexity: O((A + B)*LOG(A+B)),  Space complexity: O(A+B)
    public List<Interval> timeIntersection2(List<Interval> seqA, List<Interval> seqB) {
        final List<Interval> list = new LinkedList<>();

        final Map<Integer, Integer> map = new TreeMap<>();
        for(Interval i : seqA) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        for(Interval i : seqB) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }

        int count = 0, start = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(count == 2 && start>=0){
                list.add(new Interval(start, entry.getKey()));
                start = -1;
            }
            count += entry.getValue();
            if(count == 2) start = entry.getKey();
        }

        return list;
    }
}
