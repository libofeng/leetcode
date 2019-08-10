package com.leetcode.contest.biweekly.contest6;

import java.util.*;

public class No1152AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        final int n = username.length;

        Set<String> websites = new HashSet<>(Arrays.asList(website));

        Map<String, List<Data>> userVisits = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Data d = new Data(username[i], timestamp[i], website[i]);
            if (!userVisits.containsKey(username[i])) userVisits.put(username[i], new ArrayList<>());
            userVisits.get(username[i]).add(d);
        }
        for (List<Data> userVisitList : userVisits.values()) userVisitList.sort((a, b) -> a.t - b.t);

        String[] best = new String[3];
        int maxHit = -1;
        for (String a : websites) {
            for (String b : websites) {
                for (String c : websites) {

                    int hit = 0;
                    String[] path = new String[]{a, b, c};
                    for (List<Data> l : userVisits.values()) if (isMatch(a, b, c, l)) hit++;

                    if (hit > maxHit || hit == maxHit && compare(path, best) < 0) {
                        best = path;
                        maxHit = hit;
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(best));
    }

    private boolean isMatch(String a, String b, String c, List<Data> l) {
        int match = 0;
        for (Data d : l) {
            if (match == 0) {
                if (d.w.equals(a)) match = 1;
            } else if (match == 1) {
                if (d.w.equals(b)) match = 2;
            } else if (match == 2) {
                if (d.w.equals(c)) match = 3;
            }
        }
        return match == 3;
    }

    private int compare(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            int t = a[i].compareTo(b[i]);
            if (t != 0) return t;
        }
        return 0;
    }

    class Data {
        String u;
        int t;
        String w;

        Data(String u, int t, String w) {
            this.u = u;
            this.t = t;
            this.w = w;
        }
    }
}
