package com.leetcode.contest.contest139;

import java.math.BigInteger;
import java.util.Arrays;

public class No1073AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        BigInteger A = addByUsingBigInteger(arr1, arr2);
        if (A.signum() == 0) return new int[]{0};

        // this is the logic to convert a number to -2 based array
        int[] ret = new int[2000];
        int last = -1;
        for (int i = 0; i < 2000; i++) {
            if (A.testBit(0)) {
                ret[i] = 1;
                last = i;
                A = A.subtract(java.math.BigInteger.ONE);
            }
            A = A.divide(java.math.BigInteger.valueOf(-2));
        }
        ret = Arrays.copyOf(ret, last + 1);
        return reverse(ret);
    }

    private BigInteger addByUsingBigInteger(int[] arr1, int[] arr2) {
        BigInteger A = BigInteger.ZERO;
        for (int v : arr1) {
            A = A.multiply(BigInteger.valueOf(-2)).add(BigInteger.valueOf(v));
        }
        BigInteger B = BigInteger.ZERO;
        for (int v : arr2) {
            B = B.multiply(BigInteger.valueOf(-2)).add(BigInteger.valueOf(v));
        }
        A = A.add(B);
        return A;
    }

    private int[] reverse(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) b[a.length - 1 - i] = a[i];
        return b;
    }

}
