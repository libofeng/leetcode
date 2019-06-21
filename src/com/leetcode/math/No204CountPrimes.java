package com.leetcode.math;

public class No204CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) if (isPrime(i)) count++;
        return count;
    }

    // TLE
    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) if (n % i == 0) return false;
        return true;
    }

    // TLE
    private boolean isPrime2(int n) {
        for (int i = 2; i <= n / 2; i++) if (n % i == 0) return false;
        return true;
    }

    private boolean isPrime3(int n) {
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    // Time:O(n log log n), Space: O(N)
    public int countPrimes2(int n) {
        final boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) isPrime[j] = false;
        }

        int count = 0;
        for (int i = 2; i < n; i++) if (isPrime[i]) count++;
        return count;
    }
}
