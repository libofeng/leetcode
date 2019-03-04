package com.company.facebook;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKArrayIterator {
    class ListPointer {
        public int[] array;
        public int index;

        public ListPointer(int[] array) {
            this.array = array;
        }
    }

    private PriorityQueue<ListPointer> pq;

    public MergeKArrayIterator(ArrayList<int[]> arraylists) {
        pq = new PriorityQueue<>();
        for (int[] list : arraylists) if (list.length > 0) pq.offer(new ListPointer(list));
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public Integer next() {
        if (!hasNext()) return null;

        ListPointer pointer = pq.poll();
        int val = pointer.array[pointer.index++];
        if(pointer.index<pointer.array.length) pq.offer(pointer);
        return val;
    }
}
