##LeetCode上的Interval算法问题总结(Java描述）
*moluren@一亩三分地论坛*


#### Interval的算法问题，一般来说是基于给定Interval列表和特定条件，求Interval的交集并集（或者交集并集的Interval数量）。

假设给定的Interval对象为：

```
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
}
```
> *注意：* LeetCode后来貌似把Interval题目的方法签名做了更改：用数组表示Interval。

### LeetCode上曾经练习过的题目有：

* `56`	Merge Intervals
* `57`	Insert Interval
* `252`	Meeting Rooms
* `253`	Meeting Rooms II
* `352`	Data Stream as Disjoint Intervals
* `435`	Non-overlapping Intervals
* `436`	Find Right Interval
* `616`	Add Bold Tag in String
* `636`	Exclusive Time of Functions
* `699`	Falling Squares
* `715`	Range Module
* `759`	Employee Free Time
* `986`	Interval List Intersections

解决此类问题主要涉及到几个算法：

* 排序
* 贪心
* 扫描线
* DP

**其中排序几乎是此类问题必不可少的步骤。** 另外就是数据的比较（包括排序比较）：数据的比较不外乎是选择Interval的Start还是选择Interval的End。因而，在算法的实现上基本步骤就是排序，然后根据题目给定的条件，合理使用Start和End数据。 此外，扫描线算法（Sweep Line）在解决Interval重叠（交集）数量的问题上特别有效。**这类题有一个需要注意的地方是，区间到底是开区间还是闭区间，特别是End端点。**

Interval算法问题涉及到的数据结构有Array, List, Map, PriorityQueue。特别地，这里的Map是TreeMap主要于扫描线算法以及区间查找。

除了LeetCode上的Interval问题外，还额外地做过几道比较有意思的题目，也加到了后面“其他题目”里面。

<mark>注意！！！本文档为个人总结，不能保证思路和答案的100%正确性也不能确保为最佳方案，特别是后面“其他题目”部分。</mark>

## LeetCode算题解题思路

### 56. Merge Intervals
> Given a collection of intervals, merge all overlapping intervals.

这道题应该是最简单的Interval类问题。基本思路就是排序，排序后让可能重叠的两个Interval相邻。最后有个小问题需要注意的就是别忘记把最后一个元素加入到结果集。

```
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        intervals.sort((a, b) -> a.start - b.start);

        final List<Interval> result = new ArrayList<>();
        final Iterator<Interval> iterator = intervals.iterator();
        
        Interval current = iterator.next();
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if (next.start <= current.end) current.end = Math.max(current.end, next.end);
            else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);

        return result;
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(1)


### 57. Insert Interval
> Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

> You may assume that the intervals were initially sorted according to their start times.
 
这道题和上一道题几乎就是一样的，而且题目已经提到列表已经排序。不同之处是current元素可能出现在next的三个位置：前部、有交集、后部，需要分别处理。

```
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;

        final List<Interval> result = new ArrayList<>();
        for (Interval next : intervals) {
            if (current.end < next.start) {
                result.add(current);
                current = next;
            } else if (current.start > next.end) {
                result.add(next);
            } else {
                current.start = Math.min(current.start, next.start);
                current.end = Math.max(current.end, next.end);
            }
        }
        result.add(current);

        return result;
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(1)



### 252. Meeting Rooms
> Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] where si < ei, determine if a person could attend all meetings.


这道题和Merge Interval是类似的，只需要知道给定的Interval列表是否有重叠。另外，我们也可以使用扫描线算法判断是否有重叠。

### 解法一：
> 排序，然后判断相邻Interval是否有重叠

```
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        intervals.sort((a, b) -> a.start - b.start);

        final Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();

        while (iterator.hasNext()) {
            Interval next = iterator.next();
            if (next.start < current.end) return false;

            current = next;
        }

        return true;
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(1)


### 解法二：
> 扫描线算法，使用List作为端点容器然后排序

```
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;

        final List<int[]> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(new int[]{i.start, 1});
            list.add(new int[]{i.end, -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

        int h = 0;
        for (int[] p : list) if ((h += p[1]) > 1) return false;

        return true;
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(N)

### 解法三：
> 扫描线算法，使用TreeMap作为容器自动排序

```
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;

        final Map<Integer, Integer> tm = new TreeMap<>();
        for (Interval i : intervals) {
            tm.put(i.start, tm.getOrDefault(i.start, 0) + 1);
            tm.put(i.end, tm.getOrDefault(i.end, 0) - 1);
        }

        int h = 0;
        for (int v : tm.values()) if ((h += v) > 1) return false;

        return true;
   	}
```
> 时间复杂度：O(NLogN) 空间复杂度：O(N)



### 253. Meeting Rooms II
> Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] where si < ei, find the minimum number of conference rooms required.


这道题和上一道题类似，但是需要求最少的会议室数量其实就是最大的Interval重叠数量。可以先排序接着使用贪心算法，另外也用扫描线算法。

### 解法一：
> 排序 + 贪心算法：每次都尝试使用最早结束的会议室，如果不存在合适的就使用一个新的会议室

```
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        final Queue<Integer> pq = new PriorityQueue<>();
        for (Interval next : intervals) {
            if (!pq.isEmpty() && next.start > pq.peek()) pq.poll();
            pq.offer(next.end);
        }

        return pq.size();
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(N)


### 解法二：
> 扫描线算法，使用List作为容器然后排序

```
    public int minMeetingRooms(List<Interval> intervals) {
        final List<int[]> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(new int[]{i.start, 1});
            list.add(new int[]{i.end, -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

        int max = 0, h = 0;
        for (int[] p : list) max = Math.max(max, h += p[1]);

        return max;
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(N)

### 解法三：
> 扫描线算法，使用TreeMap作为容器自动排序

```
    public int minMeetingRooms(List<Interval> intervals) {
        final Map<Integer, Integer> tm = new TreeMap<>();
        for (Interval i : intervals) {
            tm.put(i.start, tm.getOrDefault(i.start, 0) + 1);
            tm.put(i.end, tm.getOrDefault(i.end, 0) - 1);
        }

        int max = 0, h = 0;
        for (int v : tm.values()) max = Math.max(max, h += v);

        return max;
    }
```
> 时间复杂度：O(NLogN) 空间复杂度：O(N)

### 352. Data Stream as Disjoint Intervals

> Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

这道题其实也可以看成是Interval的合并：把新的数字看成是Interval [a[n], a[n]]，然后执行合并操作。这里有一个特点需要注意：已经存在的Intervals已经是不相交的，新插入的Interval只可能最多和相邻的两个Interval有交集。

> 排序 + 二分查找：TreeMap

```
public class SummaryRanges {
    private final TreeMap<Integer, Interval> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer lo = map.lowerKey(val), hi = map.higherKey(val);

        if (lo != null && hi != null && map.get(lo).end + 1 == val && hi == val + 1) {
            map.get(lo).end = map.get(hi).end;
            map.remove(hi);
        } else if (lo != null && map.get(lo).end >= val - 1) {
            map.get(lo).end = Math.max(map.get(lo).end, val);
        } else if (hi != null && hi == val + 1) {
            map.put(val, new Interval(val, map.get(hi).end));
            map.remove(hi);
        } else map.put(val, new Interval(val, val));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
```

> 时间复杂度：O(NLogN) 空间复杂度：O(N)


### 435. Non-overlapping Intervals

> Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

这道题属于Interval的相交问题。和之前的思路类似，首先就是排序然后采用贪心算法：两个相交的Interval移除end大的那个，因为这样才可能减少进一步存在相交的可能。这里排序有一个比较特殊的地方就是，如果两个Interval的start一样，哪个在前？按照贪心算法的需要，应该end大的在前。

> 排序 + 贪心算法

```
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        int count = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (end > interval[0]) {
                end = Math.min(end, interval[1]);
                count++;
            } else end = interval[1];
        }

        return count;
    }
```

> 时间复杂度：O(NLogN) 空间复杂度：O(1)

### 436. Find Right Interval

> Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

> For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

这道题属于Interval的查找，因而需要排序并实现二分查找，最简单就是使用TreeMap。

> 排序 + 二分查找

```
    public int[] findRightInterval(int[][] intervals) {
        final int n = intervals.length;
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) tm.putIfAbsent(intervals[i][0], i);

        final int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> ceiling = tm.ceilingEntry(intervals[i][1]);
            result[i] = ceiling == null ? -1 : ceiling.getValue();
        }

        return result;
    }
```

> 时间复杂度：O(NLogN) 空间复杂度：O(N)


### 616.Add Bold Tag in String

> Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

这是一道比较有意思的题，也是让我感觉到刷题和实际工作应用建立起联系的其中一道题。这道题的核心还是构建Interval列表并合并**重叠和连续的**Interval。

> 排序，合并重叠和连续的Interval

```
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = buildIntervals(s, dict);
        intervals = mergeOverlap(intervals);
        return buildBoldString(s, intervals);
    }

    // Time: O(M*N), Space: O(M * N)
    private List<Interval> buildIntervals(String s, String[] dict) {
        final List<Interval> result = new ArrayList<>();

        for (String w : dict) {
            for (int i = 0; i <= s.length() - w.length(); i++) {
                if (s.substring(i).startsWith(w)) {
                    result.add(new Interval(i, i + w.length() - 1));
                }
            }
        }

        return result;
    }

    // Time: O(M * N * Log(M*N)), Space: O(M*N)
    private List<Interval> mergeOverlap(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        final List<Interval> result = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);

        final Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if (next.start - 1 <= current.end) {
                current.end = Math.max(current.end, next.end);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);

        return result;
    }

    // Time: O(M * N), Space: O(M)
    private String buildBoldString(String s, List<Interval> intervals) {
        final StringBuilder sb = new StringBuilder();

        int start = 0;
        for (Interval interval : intervals) {
            if (start < interval.start) {
                sb.append(s.substring(start, interval.start));
            }

            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end + 1));
            sb.append("</b>");

            start = interval.end + 1;
        }
        if (start < s.length()) sb.append(s.substring(start));

        return sb.toString();
    }
```
> 假设s长度是M，字典长度是N。
> 时间复杂度：O(M * N * Log(M * N)), 空间复杂度：O(M * N)



### 636. Exclusive Time of Functions

> On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

> We store logs in timestamp order that describe when a function is entered or exited.

> Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

> A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

> Return the exclusive time of each function, sorted by their function id.

这道题归纳成Interval可能有点牵强，或许放到Stack类型更合适。就是按照方法调用栈的思路去解决即可，减去嵌套调用栈的时间。

> 排序，合并重叠和连续的Interval

```
    public int[] exclusiveTime(int n, List<String> logs) {
        final Stack<int[]> stack = new Stack<>();
        final int[] result = new int[n];
        
        for(String log : logs){
            String[] token = log.split(":");
            int id = Integer.parseInt(token[0]), time = Integer.parseInt(token[2]);
            
            if("end".equals(token[1])){
                int start = stack.pop()[1], duration = time - start + 1;
                result[id] += duration;
                if(!stack.isEmpty()) result[stack.peek()[0]] -= duration;
            }else stack.push(new int[]{id, time});
        }
        
        return result;
    }
```

> 时间复杂度：O(N), 空间复杂度：O(N)


### 699. Falling Squares

> On an infinite number line (x-axis), we drop given squares in the order they are given.

> The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] and sidelength positions[i][1].

> The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed squares. We wait for each square to stick before dropping the next.

> The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.

> Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].

感觉这道题好难啊，首先可以想到的是暴力解法，其次是思考如何降低暴力解法O(N^2)的复杂度。

###解法一

> 暴力解法。此算法可以用TreeMap优化查找，但是最坏的情形还是O(N^2)

```
   class Interval {
        int start, end, height;

        Interval(int s, int e, int h) {
            start = s;
            end = e;
            height = h;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        final List<Interval> intervals = new ArrayList<>();
        final List<Integer> result = new ArrayList<>();

        int maxHeight = 0;
        for (int[] p : positions) {
            Interval interval = new Interval(p[0], p[0] + p[1] - 1, p[1]);
            interval.height += findBaseHeight(intervals, interval);
            intervals.add(interval);

            maxHeight = Math.max(maxHeight, interval.height);
            result.add(maxHeight);
        }

        return result;
    }

    private int findBaseHeight(List<Interval> intervals, Interval interval) {
        int baseHeight = 0;
        for (Interval i : intervals) {
            if (i.end < interval.start || i.start > interval.end) continue;
            baseHeight = Math.max(baseHeight, i.height);
        }

        return baseHeight;
    }
```

> 时间复杂度：O(N^2), 空间复杂度：O(N)


###解法二

> 使用高度线去记录高度的区间。每次插入新的区间时移除新区间内的记录。Map中存储的数据和SkyLine那道题很像（但不完全一样），是整个高度的轮廓。
> 
> 每次计算高度，查找区间内（重叠，即可以让新方块堆上去）的最大高度，加上方块自身的高度得出新区间的高度。
> 将新区间内的旧的记录删除，取而代之的是新区间和新高度。同时，在区间末端恢复到新区间左边区域的高度。

**参考此图，但是不完全一样**
![The SkyLine Problem](http://i61.tinypic.com/2vtdqtf.jpg)

```
   public List<Integer> fallingSquares(int[][] positions) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        final List<Integer> result = new ArrayList<>();
        tm.put(0, 0);

        int maxHeight = 0;
        for (int[] p : positions) {
            int start = p[0], h = p[1], end = start + h;
            int height = findBaseHeight(tm, start, end) + h;

            Integer floorKey = tm.floorKey(end);
            tm.put(start, height);
            tm.put(end, tm.get(floorKey));

            removeInnerKeys(tm, start, end);

            maxHeight = Math.max(maxHeight, height);
            result.add(maxHeight);
        }

        return result;
    }

    private int findBaseHeight(TreeMap<Integer, Integer> tm, int start, int end) {
        Integer nextKey = tm.floorKey(start);
        int height = 0;
        while (nextKey != null && nextKey < end) {
            height = Math.max(height, tm.get(nextKey));
            nextKey = tm.higherKey(nextKey);
        }

        return height;
    }

    private void removeInnerKeys(TreeMap<Integer, Integer> tm, int start, int end) {
        Integer nextKey = tm.higherKey(start);
        while (nextKey != null && nextKey < end) {
            tm.remove(nextKey);
            nextKey = tm.higherKey(nextKey);
        }
    }
```

> 时间复杂度：O(NLogN), 空间复杂度：O(N)

### 986. 715. Range Module

> A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.


> addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.

> queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.

> removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).

这是一道很适合作为训练Inerval合并和删除的题目。由于需要找到合并、删除操作相关的Interval，需要使用有序的集合数据结构。（这道题是自己做到快要吐血的题，主要问题在于处理开闭区间上）

> TreeMap: TreeMap的tailMap方法可以根据Key找到比key大的子集合视图。

```
 class RangeModule {
    private TreeMap<Integer, Interval> tm = new TreeMap<>();
    
    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        final Iterator<Map.Entry<Integer, Interval>> iterator = tm.tailMap(left).entrySet().iterator();

        while (iterator.hasNext()) {
            Interval interval = iterator.next().getValue();
            if (interval.start > right) break;

            left = Math.min(left, interval.start);
            right = Math.max(right, interval.end);
            iterator.remove();
        }
        tm.put(right, new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Integer ceilingKey = tm.ceilingKey(right);
        return ceilingKey != null && tm.get(ceilingKey).start <= left;
    }

    public void removeRange(int left, int right) {
        final Iterator<Map.Entry<Integer, Interval>> iterator = tm.tailMap(left, false).entrySet().iterator();
        final List<Interval> todo = new ArrayList<>();

        while (iterator.hasNext()) {
            Interval interval = iterator.next().getValue();
            if (interval.start > right) break;

            if (interval.start < left) todo.add(new Interval(interval.start, left));
            if (interval.end > right) todo.add(new Interval(right, interval.end));

            iterator.remove();
        }

        for (Interval interval : todo) tm.put(interval.end, interval);
    }
}
```

> 空间复杂度：O(N) 
> 
> **AddRange** 时间复杂度：O(N)
> 
> **QueryRange** 时间复杂度：O(LogN)
>
> **RemoveRange** 时间复杂度：O(N)


### 759.Employee Free Time

> We are given a list schedule of employees, which represents the working time for each employee.

> Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

> Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

这道题的本质还是合并Interval，首先要进行排序。排序后，当发现两个相邻Interval重叠，则合并；否则，把间隙创建一个FreeTime Interval。

###解法一
> 排序：合并重叠的Interval，或者创建FreeTime Interval

```
    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        final List<Interval> list = new LinkedList<>(), result = new LinkedList<>();
        for (List<Interval> intervals : schedules) list.addAll(intervals);
        if (list.size() <= 1) return list;

        list.sort((a, b) -> a.start == b.start ? (a.end - b.end) : (a.start - b.start));

        final Iterator<Interval> iterator = list.iterator();
        Interval current = iterator.next();
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if (next.start <= current.end) {
                current.end = Math.max(current.end, next.end);
            } else {
                result.add(new Interval(current.end, next.start));
                current = next;
            }
        }

        return result;
    }
```
> 时间复杂度：O(NLogN), 空间复杂度：O(N) 

###解法二
> 扫描线算法：当高度为0时设定FreeTime Interval的起点；高度为1时尝试创建FreeTime Interval

```
    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        final Map<Integer, Integer> tm = new TreeMap<>();

        for (List<Interval> intervals : schedules) {
            for (Interval i : intervals) {
                tm.put(i.start, tm.getOrDefault(i.start, 0) + 1);
                tm.put(i.end, tm.getOrDefault(i.end, 0) - 1);
            }
        }

        int h = 0, start = 0;
        final List<Interval> result = new LinkedList<>();
        for (int key : tm.keySet()) {
            h += tm.get(key);

            if (h == 0) start = key;
            else {
                if (start > 0) result.add(new Interval(start, key));
                start = 0;
            }
        }

        return result;
    }
```

> 时间复杂度：O(NLogN), 空间复杂度：O(N) 

### 986. Interval List Intersections

> Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

> Return the intersection of these two interval lists.

> (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

由于这道题已经排序，接下来基本就是贪心策略的选择。

> 双指针 + 贪心：每次移动end小的数组指针，这样才有可能得到更多的交集。

```
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        final List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i], b = B[j];

            int[] ab = intersection(a, b);
            if (ab != null) list.add(ab);

            if (a[0] < b[0]) i++;
            else j++;
        }

        return list.toArray(new int[list.size()][2]);
    }

    private int[] intersection(int[] a, int[] b) {
        if (a[1] < b[0] || a[0] > b[1]) return null;
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
```

> 时间复杂度：O(N), 空间复杂度：O(N) 

## 其他题目
<mark>注意！！！本文档为个人总结，不能保证思路和答案的100%正确性也不能确保为最佳方案。</mark>

### Contained Intervals
*https://csacademy.com/contest/interview-archive/task/contained-intervals/*

这道题在后面参考的知乎文章里看到，里面对解题思路解释得很清楚，主要就是排序。排序后，后面的Interval.start会小于等于前面的Interval.start，因而只要保证当前Interval.end小于等于目前最大的maxEnd，当前Interval就是被包含的。有个特殊情况就是当前后两个Interval完全一样的时候。

> 排序

```
    int countContainedInterval(List<Interval> intervals) {
        int count = 0;
        if (intervals.size() <= 1) return count;

        intervals.sort((a, b) -> a.start == b.start ? (b.end - a.end) : (a.start - b.start));

        Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();
        int maxEnd = -1;
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if ((current.start == next.start && current.end == next.end) || maxEnd >= current.end) count++;
            current = next;
            maxEnd = Math.max(maxEnd, current.end);
        }
        if (maxEnd >= current.end) count++;

        return count;
    }
```

> 时间复杂度：O(NLogN), 空间复杂度：O(1) 


### Cover Interval

> 给定一个Interval列表和一个目标Interval，问如何使用最少的Interval去覆盖到目标Interval。
> https://www.1point3acres.com/bbs/thread-224128-1-1.html

这道题基本思路也是排序和贪心算法。

> 排序 + 贪心：在Interval可以连接起来的基础上，寻找一个最远的右端点

```
    int coverInterval(List<Interval> intervals, Interval target) {
        intervals.sort((a, b) -> a.start == b.start ? (b.end - a.end) : (a.start - b.start));

        int maxEnd = target.start, nextMaxEnd = maxEnd, count = 0, i = 0;
        while (i < intervals.size() && maxEnd < target.end) {
            while (i < intervals.size() && intervals.get(i).start <= maxEnd) {
                nextMaxEnd = Math.max(nextMaxEnd, intervals.get(i++).end);
            }
            maxEnd = nextMaxEnd;
            count++;
        }

        return maxEnd < target.end ? -1 : count;
    }
```
> 时间复杂度：O(NLogN), 空间复杂度：O(1) 

### Maximum Non-overlap Intervals

> 给定一个Interval列表，求移除重叠Interval后数量最大的子集合。
> https://medium.com/cracking-the-data-science-interview/greedy-algorithm-and-dynamic-programming-a8c019928405

这道题和LeetCode 435. Non-overlapping Intervals很类似， 基本思路就是排序和贪心算法。

> 排序 + 贪心：优先算则结束早的Interval，这样有利于减少重叠。

```
    List<Interval> filter(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        intervals.sort((a, b) -> a.end - b.end);

        final List<Interval> result = new ArrayList<>();
        final Iterator<Interval> iterator = intervals.iterator();

        Interval current = iterator.next();
        result.add(current);
        while (iterator.hasNext()) {
            Interval next = iterator.next();
            if (next.start >= current.end) {
                current = next;
                result.add(current);
            }
        }

        return result;
    }
```
> 时间复杂度：O(NLogN), 空间复杂度：O(1) 

### Group Non-overlap Intervals

> 给定一个Interval列表，要求将Interval划分成组，要是每组的Interval不重叠且组数最少。
> https://medium.com/cracking-the-data-science-interview/greedy-algorithm-and-dynamic-programming-a8c019928405

基本思路就是排序和贪心算法。

> 排序 + 贪心：每次都把尽量多的不重叠的Interval加入到组内

```
       List<List<Interval>> group(List<Interval> intervals) {
        final List<List<Interval>> result = new ArrayList<>();
        if (intervals.size() <= 1) {
            result.add(intervals);
            return result;
        }

        intervals.sort((a, b) -> a.start - b.start);

        Iterator<Interval> iterator = intervals.iterator();
        while (iterator.hasNext()) {
            Interval current = iterator.next();
            final List<Interval> list = new ArrayList<>();
            list.add(current);
            iterator.remove();

            while (iterator.hasNext()) {
                Interval next = iterator.next();
                if (next.start >= current.end) {
                    list.add(next);
                    current = next;
                    iterator.remove();
                }
            }

            result.add(list);
            iterator = intervals.iterator();
        }

        return result;
    }
```
> 时间复杂度：O(N^2), 空间复杂度：O(1) 


### Maximum Weight Non-overlap Intervals

> 给定一个Interval列表，求非重叠Interval集合的最大权重。
> https://medium.com/cracking-the-data-science-interview/greedy-algorithm-and-dynamic-programming-a8c019928405

还是一样，排序是必不可少的环节，按照Interval的End排序。 然后采用暴力或者DP来解决。

###解法一
> 排序 + 暴力递归

```
    int maxWeight(List<WeightedInterval> intervals) {
        intervals.sort((a, b) -> a.end - b.end);
        return helper(intervals, intervals.size());
    }

    private int helper(List<WeightedInterval> intervals, int i) {
        if (i == 0) return 0;
        final WeightedInterval interval = intervals.get(i - 1);

        int j = i - 1;
        for (; j > 0; j--) if (intervals.get(j - 1).end < interval.start) break;

        return Math.max(interval.weight + helper(intervals, j), helper(intervals, i - 1));
    }
```
> 时间复杂度：O(2^N), 空间复杂度：O(2^N) 

###解法二
> 排序 + DP

```
    int maxWeight(List<WeightedInterval> intervals) {
        intervals.sort((a, b) -> a.end - b.end);
        final int n = intervals.size();
        final int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            WeightedInterval interval = intervals.get(i - 1);

            int j = i - 1;
            for (; j > 0; j--) if (intervals.get(j - 1).end < interval.start) break;
            dp[i] = Math.max(dp[i - 1], dp[j] + interval.weight);
        }

        return dp[n];
    }
```
> 时间复杂度：O(N^2), 空间复杂度：O(N) 

### 参考文章（致谢）：
* https://medium.com/cracking-the-data-science-interview/greedy-algorithm-and-dynamic-programming-a8c019928405
* https://zhuanlan.zhihu.com/p/26657786


