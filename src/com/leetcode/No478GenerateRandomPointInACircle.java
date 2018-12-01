package com.leetcode;

public class No478GenerateRandomPointInACircle {

    private double r, x, y;

    // https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/154037/Polar-Coordinates-10-lines
    public No478GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * r, deg = Math.random() * 2 * Math.PI;
        double px = x + len * Math.cos(deg), py = y + len * Math.sin(deg);

        return new double[]{px, py};

    }
}
