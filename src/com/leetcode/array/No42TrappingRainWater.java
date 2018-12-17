package com.leetcode.array;

public class No42TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int[] maxL = new int[height.length], maxR = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(height[i - 1], maxL[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i + 1], maxR[i + 1]);
        }

        int R = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int h = Math.min(maxL[i], maxR[i]) - height[i];
            if (h > 0) R += h;
        }

        return R;
    }

    public int trap2(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int l = 0, r = height.length - 1, R = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            if (height[l] == min) {
                l++;
                while (l < r && height[l] < min) R += min - height[l++];
            } else {
                r--;
                while (l < r && height[r] < min) R += min - height[r--];
            }
        }

        return R;
    }

    public int trap3(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int peakIndex = 0;
        for (int i = 1; i < len; i++) if (height[i] > height[peakIndex]) peakIndex = i;

        int water = 0;
        int leftPeak = height[0];
        for (int i = 1; i < peakIndex; i++) {
            leftPeak = Math.max(leftPeak, height[i]);
            water += Math.min(leftPeak, height[peakIndex]) - height[i];
        }
        int rightPeak = height[len - 1];
        for (int i = len - 2; i > peakIndex; i--) {
            rightPeak = Math.max(rightPeak, height[i]);
            water += Math.min(rightPeak, height[peakIndex]) - height[i];
        }


        return water;
    }
}
