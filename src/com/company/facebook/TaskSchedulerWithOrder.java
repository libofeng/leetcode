package com.company.facebook;

import java.util.*;

public class TaskSchedulerWithOrder {

    public String taskSchedule(int[] arr, int cycleTime) {
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        int totalIdle = 0;
        for (int i = 0; i < len; i++) {
            int index = map.getOrDefault(arr[i], -cycleTime - 1), currentIndex = totalIdle + i;

            int slot = currentIndex - index - 1;
            while (slot < cycleTime) {
                sb.append("_");
                slot++;
                totalIdle++;
            }

            map.put(arr[i], currentIndex);
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TaskSchedulerWithOrder solution = new TaskSchedulerWithOrder();
        String order = solution.taskSchedule(new int[]{1, 2, 2, 1}, 3);
        System.out.println("order = " + order);
    }
}
