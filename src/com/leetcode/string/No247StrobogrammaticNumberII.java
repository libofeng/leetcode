package com.leetcode.string;

import java.util.*;

public class No247StrobogrammaticNumberII {
    // DFS
    public List<String> findStrobogrammatic(int n) {
        return find(n, n);
    }

    private List<String> find(int n, int left) {
        if (left == 0) return Arrays.asList("");
        if (left == 1) return Arrays.asList("0", "1", "8");

        List<String> list = find(n, left - 2);
        List<String> R = new ArrayList<>();
        for (String l : list) {
            if (left != n) R.add('0' + l + '0');
            R.add('1' + l + '1');
            R.add('6' + l + '9');
            R.add('8' + l + '8');
            R.add('9' + l + '6');
        }

        return R;
    }

    // BFS
    public List<String> findStrobogrammatic2(int n) {
        List<String> list = n % 2 == 1 ? Arrays.asList("1", "8", "0") : Arrays.asList("");
        if (n <= 1) return list;

        for (int i = (n % 2) + 2; i <= n; i += 2) {
            List<String> tmp = new ArrayList<>();
            for (String s : list) {
                if (i != n) tmp.add('0' + s + '0');
                tmp.add('1' + s + '1');
                tmp.add('6' + s + '9');
                tmp.add('8' + s + '8');
                tmp.add('9' + s + '6');
            }
            list = tmp;
        }

        return list;
    }

    // BFS
    public List<String> findStrobogrammatic3(int n) {
        final List<String> result = new ArrayList<>();
        final char[] chars = new char[]{'0', '1', '6', '8', '9'};

        final Queue<String> q = new LinkedList<>();
        if ((n & 1) == 0) q.offer("");
        else for (char c : chars) if (c != '6' && c != '9') q.offer("" + c);

        int len = q.peek().length();
        while (len < n) {
            len += 2;
            int size = q.size();
            while (size-- > 0) {
                String num = q.poll();

                if (len != n) q.offer('0' + num + '0');
                q.offer('1' + num + '1');
                q.offer('6' + num + '9');
                q.offer('8' + num + '8');
                q.offer('9' + num + '6');
            }

        }

        result.addAll(q);
        return result;
    }
}
