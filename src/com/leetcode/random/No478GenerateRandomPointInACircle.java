package com.leetcode.random;

public class No478GenerateRandomPointInACircle {
    private double r, x, y;
    public No478GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double degree = Math.random() * 2 * Math.PI;
        double radius = Math.sqrt(Math.random()) * r;

        return new double[]{x + radius * Math.cos(degree), y + radius * Math.sin(degree)};
    }
}
