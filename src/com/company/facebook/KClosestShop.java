package com.company.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestShop {

    class ShopDistance {
        int id, x, y;
        Double distance;

        ShopDistance(int id, int x, int y, double d) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.distance = d;
        }
    }

    // Space: O(K), Time: O(NLogK)
    List<Integer> findKClosestShops(int[][] shopLocations, int[] userLocation, int k) {
        final List<Integer> kClosestShops = new ArrayList<>();

        // Time: O(K)
        if (k >= shopLocations.length) {
            for (int i = 0; i < shopLocations.length; i++) kClosestShops.add(i);
            return kClosestShops;
        }

        // Space: O(K)
        final Queue<ShopDistance> pq = new PriorityQueue<>((a, b) -> b.distance.compareTo(a.distance));
        for (int i = 0; i < shopLocations.length; i++) {
            int[] location = shopLocations[i];
            double distance = calcDistance(userLocation, location);
            ShopDistance shopDistance = new ShopDistance(i, location[0], location[1], distance);

            if (pq.size() < k) pq.offer(shopDistance);
            else {
                if (distance < pq.peek().distance) {
                    pq.poll(); // Time: O(LogK)
                    pq.offer(shopDistance); // Time: O(LogK)
                }
            }
        }

        while (!pq.isEmpty()) kClosestShops.add(pq.poll().id);
        return kClosestShops;
    }

    private double calcDistance(int[] user, int[] shop) {
        int dx = user[0] - shop[0], dy = user[1] - shop[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        KClosestShop solution = new KClosestShop();
        List<Integer> list = solution.findKClosestShops(new int[][]{{1, 1}, {1, 2}, {7, 8}, {4, 5}}, new int[]{0, 0}, 3);
        System.out.println("list = " + list);
    }
}
