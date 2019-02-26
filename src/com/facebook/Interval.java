package com.facebook;

public class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    @Override
    public boolean equals(Object o) {
        Interval that = (Interval) o;
        return this.start == that.start && this.end == that.end;
    }
}
