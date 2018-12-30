package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No247StrobogrammaticNumberII {
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
}
