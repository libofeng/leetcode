package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No616AddBoldTagInString {
    /**
     * @param s:    a string
     * @param dict: a list of strings
     * @return: return a string
     */
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = buildIntervals(s, dict);
        intervals = mergeOverlap(intervals);
        return buildBoldString(s, intervals);
    }

    // Time: O(M*N), Space: O(M * N)
    private List<Interval> buildIntervals(String s, String[] dict) {
        final List<Interval> result = new ArrayList<>();

        for (String w : dict) {
            for (int i = 0; i <= s.length() - w.length(); i++) {
                if (s.substring(i).startsWith(w)) {
                    result.add(new Interval(i, i + w.length() - 1));
                }
            }
        }

        return result;
    }

    // Time: O(M * N * Log(M*N)), Space: O(M*N)
    private List<Interval> mergeOverlap(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        final List<Interval> result = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);

        final Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if (next.start - 1 <= current.end) {
                current.end = Math.max(current.end, next.end);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);

        return result;
    }

    // Time: O(M * N), Space: O(M)
    private String buildBoldString(String s, List<Interval> intervals) {
        final StringBuilder sb = new StringBuilder();

        int start = 0;
        for (Interval interval : intervals) {
            if (start < interval.start) {
                sb.append(s.substring(start, interval.start));
            }

            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end + 1));
            sb.append("</b>");

            start = interval.end + 1;
        }
        if (start < s.length()) sb.append(s.substring(start));

        return sb.toString();
    }

    class Interval {
        int start, end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
