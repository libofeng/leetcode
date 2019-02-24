package com.facebook;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKArrayIterator {
    class ListPointer {
        public int[] array;
        public int index;

        public ListPointer(int[] array, int index) {
            this.array = array;
            this.index = index;
        }
    }

    private PriorityQueue<ListPointer> pq;

    public MergeKArrayIterator(ArrayList<int[]> arraylists) {
        pq = new PriorityQueue<>((a, b) -> a.array[a.index] - b.array[b.index]);
        for (int[] list : arraylists) if (list.length > 0) pq.offer(new ListPointer(list, 0));
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public Integer next() {
        if (!hasNext()) return null;

        ListPointer pair = pq.poll();
        if (++pair.index < pair.array.length) pq.offer(pair);
        return pair.array[pair.index - 1];
    }
}
