package com.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;

public class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            groups.putIfAbsent(s, new ArrayList<>());
            groups.get(s).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        Arrays.stream(strs).forEach(
                k -> groups.computeIfAbsent(normalize(k), kk -> new ArrayList<>()).add(k));
        return new ArrayList<>(groups.values());
    }

    public List<List<String>> groupAnagrams4(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(this::normalize)).values());
    }

    private String normalize(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    /*一、 什么是“素数”？

    素数是这样的整数，它除了能表示为它自己和1的乘积以外，不能表示为任何其它两个整数的乘积。例如，15＝3＊5，所以15不是素数；
    又如，12＝6＊2＝4＊3，所以12也不是素数。另一方面，13除了等于13＊1以外，不能表示为其它任何两个整数的乘积，所以13是一个素数。素数也称为“质数”。

    二、什么是“互质数”（或“互素数”）？

    小学数学教材对互质数是这样定义的：“公约数只有1的两个数，叫做互质数。”这里所说的“两个数”是指自然数。

    判别方法主要有以下几种（不限于此）：

            （1）两个质数一定是互质数。例如，2与7、13与19。

            （2）一个质数如果不能整除另一个合数，这两个数为互质数。例如，3与10、5与26。

            （3）1不是质数也不是合数，它和任何一个自然数在一起都是互质数。如1和9908。

            （4）相邻的两个自然数是互质数。如15与16。

            （5）相邻的两个奇数是互质数。如49与51。

            （6）大数是质数的两个数是互质数。如97与88。

            （7）小数是质数，大数不是小数的倍数的两个数是互质数。如7和16。

            （8）两个数都是合数（二数差又较大），小数所有的质因数，都不是大数的约数，这两个数是互质数。如357与715，357=3×7×17，
                 而3、7和17都不是715的约数，这两个数为互质数。等等。

            （9）2和任意奇数互质*/

    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }
}
