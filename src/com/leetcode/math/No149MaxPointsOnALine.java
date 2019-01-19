package com.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class No149MaxPointsOnALine {
    // https://leetcode.com/problems/max-points-on-a-line/discuss/221044/topic
    // NOT AC
    public int maxPoints(Point[] points) {
        // 边界：一共两个点你还判断个鸡毛共线
        final int len = points.length;
        if (len < 3) return len;

        int max = 0;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                // points[i] 和 points[j]
                // 这里需要一个bool值的slope 来判断斜率是否存在，不存在的话设置为false,后续单独处理
                boolean slope = true;
                int dX = points[i].x - points[j].x;
                int dY = points[i].y - points[j].y;
                int interceptDX = 0;
                if (dX == 0) {
                    // 这时候两个点连线是垂直于x轴的，木有斜率
                    slope = false;
                } else {
                    // 这个是点斜式的变形， 等式左侧是(截距*dx),自己在演算纸上验算一下吧,就不详细说了
                    interceptDX = dX * points[i].y - dY * points[i].x;
                }

                int count = 0;
                for (int k = 0; k < len; ++k) {
                    if (slope) {
                        // 将k点的x和y带入看直线方程是否有解。
                        if (interceptDX == dX * points[k].y - dY * points[k].x) {
                            ++count;
                        }
                    } else {
                        if (points[k].x == points[i].x) {
                            ++count;
                        }
                    }
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }

    /*
     *  A line is determined by two factors,say y=ax+b
     *
     *  If two points(x1,y1) (x2,y2) are on the same line(Of course).

     *  Consider the gap between two points.

     *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

     *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

     *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  So we can use y0&x0 to track a line;
     */

    // AC
    public int maxPoints2(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;


    }

    private int generateGCD(int a, int b) {

        if (b == 0) return a;
        else return generateGCD(b, a % b);

    }

    // https://blog.csdn.net/universe_ant/article/details/75332023
    // NOT AC
    public int maxPoints3(Point[] points) {
        if (points.length <= 2) return points.length;

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            final Map<Double, Integer> map = new HashMap<>();
            int vertical = 0, overlap = 1, currentMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[j].y == points[j].y) overlap++;
                else if (points[i].x == points[j].x) vertical++;
                else {
                    double slope = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    if (slope == -0.0) slope = 0.0D;

                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    currentMax = Math.max(currentMax, map.get(slope));
                }
            }

            currentMax = Math.max(currentMax, vertical) + overlap;
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
