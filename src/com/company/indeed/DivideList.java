package com.company.indeed;

import java.util.*;

public class DivideList {

    static List<List<Character>> divideList(List<Character> chars) {
        final List<List<Character>> result = new ArrayList<>();
        final Map<Character, Integer> counter = new HashMap<>();

        int max = 0;
        for (char c : chars) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
            max = Math.max(max, counter.get(c));
        }

        for (int i = 0; i < max; i++) result.add(new ArrayList<>());
        for (Map.Entry<Character, Integer> e : counter.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) result.get(i).add(e.getKey());
        }

        return result;
    }

    /*
    给一个list， 如何把里面的字符分配到尽量少的子list里，并且每个子list没有重复元素。
    比如
    ['a','b','c','a','a','b']， 可以分成['a', 'b', 'c'], ['a', 'b'], ['a']
    ['a', 'a', 'a', 'b', 'b', 'b']，可以分成['a', 'b'], ['a', 'b'], ['a', 'b']
     */
    public static void main(String[] args) {
        System.out.println(divideList(Arrays.asList('a', 'b', 'c', 'a', 'a', 'b')));
        System.out.println(divideList(Arrays.asList('a', 'a', 'a', 'b', 'b', 'b')));
    }
}
