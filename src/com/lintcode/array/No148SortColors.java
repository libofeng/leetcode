package com.lintcode.array;

public class No148SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        partition(nums, 0);
        partition(nums, 1);
    }

    private void partition(int[] nums, int pivot) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }


    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; ) {
            if (nums[i] == 1) i++;
            else if (nums[i] == 2) swap(nums, i, right--);
            else if (nums[i] == 0) swap(nums, i++, left++);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
