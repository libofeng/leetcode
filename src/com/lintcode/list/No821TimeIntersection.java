package com.lintcode.list;


import java.util.LinkedList;
import java.util.List;

public class No821TimeIntersection {

    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
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
}
