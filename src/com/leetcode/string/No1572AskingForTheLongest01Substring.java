package com.leetcode.string;

public class No1572AskingForTheLongest01Substring {
    /**
     * @param str: the string
     * @return: the length of substring
     */
    public int askingForTheLongest01Substring(String str) {
        // 这道题虽然允许我们可以做多次转换，但是其实可以证明任何大于等于2次的转换所造成的结果都可以用一次转换所得到。
        // 只不过有的时候需要从右往左看。比如 长度为n的string s, 元素代号为1, 2, ..., n.
        // 那么经过一次在第k位的切割之后，我们获得，k, k - 1, k - 2, ..., 1, n, ..., k + 1.
        // 如果第二次转换比如从第j位切割，比如j <= k,那么结果变为k - j, ..., k, k + 1, ..., n, 1, ..., k - j - 1.
        // 此时，这个等价于我们从原数据第k - j - 1位开始切割，并转换之后的倒序。但是倒序字符串不影响结果。
        // 所以我们得出结论，即两次切割所得到的结果可以用一次切割得到。
        // 故数学归纳一下即得，多次切割所得到的结果都可以用一次切割所得到。所以从现在开始，我们只需要关注一次切割。
        int maxVal = 1;

        int currMax = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                currMax++;
                maxVal = Math.max(currMax, maxVal);
            } else {
                currMax = 1;
            }
        }//先找到不切割时候的结果

        //一次切割能获得更好的结果当且仅当我们依赖首尾相连而得到更大的结果。所以此时我们只需要查看首尾相连的情况
        //if two sides are same
        if (str.charAt(0) == str.charAt(str.length() - 1)) {//这种情况下，切割无利可图
            return maxVal;
        } else {
            //find two longest combined on two sides
            int left = 1;
            int right = str.length() - 2;
            while (left < right && str.charAt(left) != str.charAt(left - 1)) {
                left++;
            }

            while (left < right && str.charAt(right) != str.charAt(right + 1)) {
                right--;
            }
            //两头扩展去找到尽可能长的首尾相连
            maxVal = Math.max(maxVal, str.length() - right - 1 + left);
        }

        return maxVal;
    }

    // DP
    public int askingForTheLongest01Substring1(String str) {
        final int len = str.length();
        final String s = str + str;
        final int[] dp = new int[len * 2];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = s.charAt(i) == s.charAt(i - 1) ? 1 : dp[i - 1] + 1;

            if (dp[i] > len) return len;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // DP2, simplified version
    public int askingForTheLongest01Substring2(String str) {
        final String s = str + str;

        int maxLen = 1, len = 1;
        for (int i = 1; i < s.length(); i++) {
            len = s.charAt(i) == s.charAt(i - 1) ? 1 : len + 1;

            if (len > str.length()) return str.length();
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }


    public int askingForTheLongest01Substring3(String str) {
        final int sLen = str.length();

        int maxLen = 1, len = 1;
        for (int i = 1; i < sLen * 2; i++) {
            len = str.charAt(i % sLen) == str.charAt((i - 1) % sLen) ? 1 : len + 1;

            if (len > sLen) return sLen;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public int askingForTheLongest01Substring4(String str) {
        int maxLen = 1, sLen = str.length();

        for (int i = 1, len = 1; i < sLen; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else len = 1;
        }

        if (str.charAt(0) == str.charAt(sLen - 1)) return maxLen;

        int right = sLen - 2, left = 1;
        while (left < right && str.charAt(left) != str.charAt(left - 1)) left++;
        while (left < right && str.charAt(right) != str.charAt(right + 1)) right--;

        return Math.max(maxLen, sLen - right - 1 + left);
    }
}
