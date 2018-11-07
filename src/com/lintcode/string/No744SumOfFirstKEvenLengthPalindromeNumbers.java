package com.lintcode.string;

public class No744SumOfFirstKEvenLengthPalindromeNumbers {
    // https://www.lintcode.com/problem/sum-of-first-k-even-length-palindrome-numbers/note/152659
    // 11, 22, 33, 44, 55, 66, 77, 88, 99, 1001, 1111, 1221, 1331, 1441, 1551, 1661…
    // '1', '2', '3',... '10', '11'...

    /**
     * @param k: Write your code here
     * @return: the sum of first k even-length palindrome numbers
     */
    public int sumKEven(int k) {
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(i);

            for (int j = builder.length() - 1; j >= 0; j--) builder.append(builder.charAt(j));
            sum += Integer.parseInt(builder.toString());
        }
        return sum;
    }
}
