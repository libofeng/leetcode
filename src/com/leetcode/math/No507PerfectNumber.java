package com.leetcode.math;

public class No507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) if (num % i == 0) sum += i;

        return sum == num;
    }

    public boolean checkPerfectNumber2(int num) {
        if (num <= 1) return false;

        int sum = 1, sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) if (num % i == 0) sum += i + num / i;
        return sum == num;
    }
}
