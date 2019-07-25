package com.leetcode.array;

import java.util.*;

public class No184Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        final List<List<Integer>> R = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int m = j + 1; m < nums.length; m++) {
                    if (m > j + 1 && nums[m] == nums[m - 1]) continue;

                    for (int n = m + 1; n < nums.length; n++) {
                        if (n > m + 1 && nums[n] == nums[n - 1]) continue;
                        if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                            R.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        }
                    }
                }
            }
        }

        return R;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        final List<List<Integer>> R = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int low = j + 1, high = nums.length - 1, num = target - nums[i] - nums[j];
                while (low < high) {
                    if (nums[low] + nums[high] == num) {
                        R.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));

                        while (low < high && nums[low] == nums[low - 1]) low++;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else if (nums[low] + nums[high] > num) {
                        high--;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else {
                        low++;
                        while (low < high && nums[low] == nums[low - 1]) low++;
                    }
                }
            }
        }

        return R;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        final List<List<Integer>> R = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;

                    int num = target - nums[i] - nums[j] - nums[k];
                    Integer index = map.get(num);
                    if (index != null && index > k) {
                        R.add(Arrays.asList(nums[i], nums[j], nums[k], nums[index]));
                    }
                }
            }
        }

        return R;
    }

    public List<List<Integer>> fourSum4(int[] nums, int target) {
        List<List<Integer>> R = new ArrayList<>();
        if (nums.length < 4) return R;

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(Arrays.asList(i, j));
            }
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int gap = target - nums[i] - nums[j];
                if (!map.containsKey(gap)) continue;
                for (List<Integer> list : map.get(gap)) {
                    Set<Integer> set = new TreeSet<>(list);
                    set.add(i);
                    set.add(j);

                    if (set.size() < 4) continue;

                    List<Integer> r = new ArrayList<>();
                    for (int k : set) r.add(nums[k]);
                    r.sort((a, b) -> a - b);

                    String resultKey = r.toString();
                    if (!result.contains(resultKey)) R.add(r);
                    result.add(resultKey);
                }
            }
        }

        return R;
    }

    public List<List<Integer>> fourSum5(int[] nums, int target) {
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();

        helper(nums, target, result, 0, 4, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int target, List<List<Integer>> result, int index, int k, List<Integer> list) {
        if (k == 2) {
            int lo = index, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    final List<Integer> r = new ArrayList<>(list);
                    r.add(nums[lo++]);
                    r.add(nums[hi--]);
                    result.add(r);

                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (sum < target) lo++;
                else hi--;
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1]) continue;

                list.add(nums[i]);
                helper(nums, target - nums[i], result, i + 1, k - 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
