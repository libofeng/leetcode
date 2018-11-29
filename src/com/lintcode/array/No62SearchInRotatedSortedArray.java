package com.lintcode.array;

public class No62SearchInRotatedSortedArray {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while(left<=right){
            final int mid = left + (right - left) / 2;
            if(target == A[mid]) return mid;

            if(A[left] < A[right]){
                if(target < A[mid]) right = mid - 1;
                else left = mid + 1;
            }else{
                if(A[mid] >= A[left]){
                    if(target<A[mid] && target>=A[left]) right = mid -1;
                    else left = mid + 1;
                }else{
                    if(target>A[mid] && target<=A[right]) left = mid + 1;
                    else right = mid - 1;
                }
            }
        }

        return -1;
    }
}
