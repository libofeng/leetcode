package com.lintcode.array;

public class No64MergeSortedArray {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m -1, j = n - 1, index = m + n -1;
        while(j>=0){
            int n1 = i>=0? A[i] : Integer.MIN_VALUE, n2 = B[j];
            A[index--] = n1 > n2 ? A[i--] : B[j--];
        }
    }
}
