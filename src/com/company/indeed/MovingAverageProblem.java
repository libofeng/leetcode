package com.company.indeed;

import java.util.*;

/*

我第一个方法说用一个heap去存items, 并且分析这个做法的複杂度(insert , remove等等的...)
面试官好像很困惑如何从heap裡面Remove特定的item


需要考虑的极端情况是，如果一直都在record，但是没有人call getAverage()，有可能会内存不够
解决的方法有2种. Waral 鍗氬鏈夋洿澶氭枃绔ð,
方法1：可以每次record的时候，对queue进行一次过滤，把超过5分钟的entry删掉，然后call getAverage()的时候，再进行一次过滤
这个方法的好处是，把需要过滤的元素平摊到了每一次record上，最后call getAverage()的时候，需要规律的元素会少一些
tradeoff就是，会拉低每次record的效率，因为每次record都在过滤

方法2：每次call getAverage()的时候，对queue进行一次整体过滤
好处在于，record的效率会相对快，因为不用去过滤掉过期的元素
缺点就是，有可能会内存不够，因为过滤这个action只发生在getAverage()的时候. 鐣欏鐢宠璁哄潧

一直输入integer，每个interger有一个timestamp，然后移除超过10000毫秒的interger，实现record方法和get averge方法. visit 1point3acres.com for more.
followup：get medium（解：quick select）--followup：如果getmedium用的很频繁怎么办（解：输入进queue的时候就sort）
【第二个followup想了一会，给了hint才弄出来】


public double getAvg(int[] A); 返回call这个函数时倒数5分钟内数据的平均值 有个一 public long time(); 可以用来返回当前时间。
如果数据点非常密集，5分钟内的所有点会爆内存怎么办，可以把10秒之内的数据进行合并.


follow up: 我们需要找median，就是中位数
其实就是一个find median in unsorted array
方法也有两种：
方法1：quick select，每次平均速度O（n），最坏速度O(n^2)，如果需要call n次的话，就是n^2和n^3
方法2：max/min heap，总体速度O(nLogn)
我提出了，可以根据需求来决定用那一种，如果找median的次数没有那么多，那么选quick select，因为单次的平均速度是O(n)
如果call的次数比较多，那么方法2比较好
面试官表示满意，最后留了10分钟聊天


有follow up问如何很快的给出median，可以用linkedlist或者2 heaps维护，这样加入的时候会复杂很多但是维护和输出median很方便

如果还要getMedium呢？我说用two heap，他说太慢了因为record要o(logN)，说这个getMedium call得很少，可以直接在当前的数据结构上implement，于是其实就是求unsorted list的medium，用quick select能O(n)时间得到，面试官表示很满意。


 */
public class MovingAverageProblem {

    class Event {
        int timestamp;
        int val;
        public Event(int timestamp, int val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    int sum;
    LinkedList<Event> queue = new LinkedList<>();

    public void record(int timestamp, int val) {
        queue.add(new Event(timestamp, val));
        sum += val;
    }

    public double getAvg(int timestamp) {
        while (!queue.isEmpty() && queue.peek().timestamp + 300 < timestamp) {
            sum -= queue.remove().val;
        }

        return sum * 1.0 / queue.size();
    }

    public int getMedian() {
        return medianHelper(0, queue.size() - 1, queue.size() / 2);
    }

    private int medianHelper(int start, int end, int k) {
        int low = start, high = end;
        int mid = queue.get(start + (end - start) / 2).val;
        while (low <= high) {
            while (low <= high && queue.get(low).val < mid)
                low++;
            while (low <= high && queue.get(high).val > mid)
                high--;

            if (low <= high) {
                int tmp = queue.get(low).val;
                queue.get(low).val = queue.get(high).val;
                queue.get(high).val = tmp;
            }
        }

        if (start <= high && k <= high)
            return medianHelper(start, high, k);
        else if (low <= end && k >= low)
            return medianHelper(low, end, k);
        else
            return queue.get(k).val;
    }
}

class MovingAverage2 {

    int[] timestamps = new int[300];
    int[] values = new int[300];
    int[] counts = new int[300];

    public void record(int timestamp, int val) {
        int index = timestamp % 300;
        if (timestamps[index] != timestamp) {
            timestamps[index] = timestamp;
            values[index] = val;
            counts[index] = 1;
        } else {
            values[index] += val;
            counts[index]++;
        }
    }

    public double getAvg(int timestamp) {
        int sum = 0, count = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamps[i] + 300 >= timestamp) {
                sum += values[i];
                count += counts[i];
            }
        }
        return sum * 1.0 / count;
    }


}

class MedianHolder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void add(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        } else {
            if (maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                if (minHeap.isEmpty()) {
                    minHeap.add(num);
                    return;
                }

                if (minHeap.peek() > num) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }
        balanceHeapSize();
    }

    public Integer getMedian() {
        int maxHeapSize = this.maxHeap.size();
        int minHeapSize = this.minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
        Integer maxHeapHead = this.maxHeap.peek();
        Integer minHeapHead = this.minHeap.peek();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeapHead + minHeapHead) / 2;
        }
        return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;

    }
    private void balanceHeapSize() {
        if (maxHeap.size() + 2 == minHeap.size())
            maxHeap.add(minHeap.remove());
        else if (minHeap.size() + 2 == maxHeap.size())
            minHeap.add(maxHeap.remove());
    }


}
