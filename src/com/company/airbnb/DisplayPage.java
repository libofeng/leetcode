package com.company.airbnb;

import java.util.*;

public class DisplayPage {
    public static void main(String[] args) {
        DisplayPage solution = new DisplayPage();
        String[] strs = new String[]{
                "1,28,300.1,SanFrancisco",
                "4,5,209.1,SanFrancisco",
                "20,7,208.1,SanFrancisco",
                "23,8,207.1,SanFrancisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,SanFrancisco",
                "6,29,204.1,SanFrancisco",
                "7,20,203.1,SanFrancisco",
                "8,21,202.1,SanFrancisco",
                "2,18,201.1,SanFrancisco",
                "2,30,200.1,SanFrancisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,SanJose",
                "6,25,10.1,Oakland",
                "19,15,9.1,SanJose",
                "3,19,8.1,SanJose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,SanJose",
                "5,6,3.1,SanJose",
                "29,22,2.1,SanJose",
                "30,23,1.1,SanJose"
        };
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        List<String> result = solution.displayPages2(input, 12);
        assert (32 == result.size());
        assert ("1,28,300.1,SanFrancisco".equals(result.get(0)));
        assert ("11,26,107.1,Oakland".equals(result.get(11)));
        assert ("".equals(result.get(12)));
        assert ("1,16,205.1,SanFrancisco".equals(result.get(13)));
        assert ("2,30,200.1,SanFrancisco".equals(result.get(14)));
        assert ("25,4,4.1,SanJose".equals(result.get(24)));
        assert ("".equals(result.get(25)));
        assert ("1,2,103.1,Oakland".equals(result.get(26)));
        assert ("3,11,7.1,Oakland".equals(result.get(27)));
        assert ("30,23,1.1,SanJose".equals(result.get(30)));
        assert ("1,3,5.1,Oakland".equals(result.get(31)));
    }

    private List<String> displayPages(List<String> list, int pageSize) {
        final List<String> result = new ArrayList<>();
        final Set<String> used = new HashSet<>();

        int itemCount = 0;
        while (list.size() > 0) {
            used.clear();
            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {

                String row = iterator.next();
                String[] data = row.split(",");
                if (!used.add(data[0])) continue;

                result.add(row);
                iterator.remove();

                if (++itemCount % pageSize == 0) {
                    result.add("");
                    break;
                }
            }
        }

        return result;
    }

    private List<String> displayPages2(List<String> list, int pageSize) {
        final List<String> result = new ArrayList<>();
        Map<String, Item> map = new HashMap<>();
        // O(N)
        for (String l : list) {
            String[] data = l.split(",");
            if (!map.containsKey(data[0])) map.put(data[0], new Item());
            map.get(data[0]).add(l);
        }

        final Queue<Item> pq = new PriorityQueue<>(map.values());

        // O(NLogN)
        int count = 0;
        List<Item> waitList = new ArrayList<>();
        while (!pq.isEmpty()) {
            Item item = pq.poll();

            result.add(item.list.get(item.index++));
            if (item.index < item.list.size()) {
                item.setScore();
                waitList.add(item);
            }

            if (++count % pageSize == 0 && !pq.isEmpty()) result.add("");
            if (count % pageSize == 0 || pq.isEmpty()) {
                pq.addAll(waitList);
                waitList.clear();
            }
        }

        return result;
    }

    class Item implements Comparable<Item> {
        List<String> list = new ArrayList<>();
        Double score = 0D;
        int index = 0;

        void add(String l) {
            list.add(l);
            if (list.size() == 1) setScore();
        }

        @Override
        public int compareTo(Item that) {
            return that.score.compareTo(this.score);
        }

        void setScore() {
            score = Double.parseDouble(list.get(index).split(",")[2]);
        }
    }
}
