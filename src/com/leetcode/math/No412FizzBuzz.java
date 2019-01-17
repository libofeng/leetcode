package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class No412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % (3 * 5) == 0) list.add("FizzBuzz");
            else if (i % 3 == 0) list.add("Fizz");
            else if (i % 5 == 0) list.add("Buzz");
            else list.add("" + i);
        }

        return list;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>(n);

        for (int i = 1, fizz = 1, buzz = 1; i <= n; i++, fizz++, buzz++) {
            if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            } else if (fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            } else list.add("" + i);
        }

        return list;
    }
}
