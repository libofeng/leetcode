package com.company.indeed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SortedStreamApp {
    private static final class ArrayBackedStream implements SortedStream {
        final int[] data;
        int index = -1;

        ArrayBackedStream(final int[] data) {
            this.data = data;
        }

        @Override
        public boolean move() {
            return (++index < data.length);
        }

        @Override
        public int value() {
            return data[index];
        }
    }

    public interface SortedStream {
        /*
         * Positions the stream at the next valid integer.
         * @return true iff the stream was positioned at a valid integer.
         */
        boolean move();

        /*
         *
         *@return the integer at the current position.
         *@throws RuntimeException if called before calling move() at least once or called
         *        after move() returned false.
         */
        int value();
    }

    private static List<Integer> getNumbersInAtLeastKStreams(final List<SortedStream> streams, int k) {
        final List<Integer> result = new ArrayList<>();
        if (streams == null || streams.size() == 0 || k < 0) {
            return result;
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (SortedStream stream : streams) {
            long last = Long.MIN_VALUE;
            while (stream.move()) {
                int current = stream.value();
                if (last == current || map.getOrDefault(current, 0) == -1) continue;

                map.put(current, map.getOrDefault(current, 0) + 1);
                if (map.get(current) >= k) {
                    result.add(current);
                    map.put(current, -1);
                }

                last = current;

            }
        }

        return result;
    }

    // public  SortedStream readyFromSoruece (SortedStream largeSteam , int size) {
    //     SortedStream shortSteam = new SortedStream( new int[size]);
    //     int index = 0;
    //     int[] data  = new int[size];
    //   while( i< size0 && shortSteam.move() )  {
    //       data[i++] = shortSteam.value();
    //   }
    //   return shortStream;
    // }

    public static void main(String[] args) {

        List<SortedStream> testList = new ArrayList<>();
        int[] data1 = {-1, 3, 5, 6, 6, 7, 9, 12, 14, 15, 16, 17, 18, 19, 21, 22, 51};
        SortedStream stream1 = new ArrayBackedStream(data1);
        testList.add(stream1);
        int[] data2 = {0, 3, 5, 5, 9, 13, 15, 51};
        SortedStream stream2 = new ArrayBackedStream(data2);
        testList.add(stream2);
        int[] data3 = {5, 5, 7, 11, 19, 21, 501};
        SortedStream stream3 = new ArrayBackedStream(data3);
        testList.add(stream3);
        System.out.println(find(testList, 2)); // [3, 5, 7, 9, 15, 19, 21, 51]
//        System.out.println(getNumbersInAtLeastKStreams(testList, 2)); // [3, 5, 9, 15, 51, 7, 19, 21]
    }

    //-1 3 5 6 6 7 9 12 14
    //0 3 5 5 9 13 15
    //5 5 7 11 19 21 51

    //k = 3

    //streams.size() (m) is small
    //but number of elements in stream is large

    //3 5 7 9

    public static List<Integer> find(List<SortedStream> list, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<SortedStream> heap = new PriorityQueue<>(new SortedStreamComparator());
        for (SortedStream st : list) if (st.move()) heap.offer(st);
        if (heap.isEmpty()) return result;

        int curVal = -1, count = 0;
        while (!heap.isEmpty()) {
            SortedStream currentStream = heap.poll();
            if (count == 0 || currentStream.value() != curVal) {
                if (count >= k) result.add(curVal);
                if (heap.size() < k - 1) break;

                curVal = currentStream.value();
                count = 1;
            } else count++;

            while (currentStream.move()) {
                if (currentStream.value() != curVal) {
                    heap.offer(currentStream);
                    break;
                }
            }
        }

        return result;
    }

    public static class SortedStreamComparator implements Comparator<SortedStream> {
        @Override
        public int compare(SortedStream s1, SortedStream s2) {
            return s1.value() - s2.value();
        }
    }

    final static class DataObj {
        int val;
        SortedStream stream;

        public DataObj(SortedStream ite) {
            this.stream = ite;
            this.val = ite.value();
        }
    }

}
