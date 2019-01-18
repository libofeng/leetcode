package com.leetcode.array;

import java.util.*;

public class No347TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() == k) {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            } else pq.offer(entry);
        }

        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : pq) list.add(e.getKey());
        return list;
    }


    // Bucket Sort
    public List<Integer> topKFrequent2(int[] nums, int k) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        for(int c : nums) frequency.put(c, frequency.getOrDefault(c, 0) + 1);

        final List[] buckets = new List[nums.length + 1];
        for(int i = 0; i<buckets.length; i++) buckets[i] = new ArrayList<>();
        for(int key : frequency.keySet()) buckets[frequency.get(key)].add(key);

        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length - 1;i>=0 && result.size()<k;i--){
            for(Object n : buckets[i]) if(result.size()<k) result.add((Integer) n);
        }

        return result;
    }
}
