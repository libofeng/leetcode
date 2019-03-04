package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        final Map<String, Long> counter = new HashMap<>();
        for(String d : cpdomains){
            String[] data = d.split(" ");

            long count = Long.parseLong(data[0]);
            String domain = data[1];
            counter.put(domain, counter.getOrDefault(domain, 0L) + count);

            for(int i = 0; i<domain.length();i++){
                char c = domain.charAt(i);
                if(c == '.') {
                    String parent = domain.substring(i+1);
                    counter.put(parent, counter.getOrDefault(parent, 0L) + count);
                }
            }
        }

        final List<String> result = new ArrayList<>();
        for(Map.Entry<String, Long> e : counter.entrySet()) result.add(e.getValue() + " " +e.getKey());
        return result;
    }
}
