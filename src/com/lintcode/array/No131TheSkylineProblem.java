package com.lintcode.array;

import java.util.*;

public class No131TheSkylineProblem {
    // reference: https://blog.csdn.net/zxzxzx0119/article/details/81704342

    //由一座大楼可以生成两个信息，一个是开始，高度，和上升
    private static class Node {
        public int pos; //position
        public int h; //height
        public boolean isUp;

        public Node(int pos, int h, boolean isUp) {
            this.pos = pos;
            this.h = h;
            this.isUp = isUp;
        }
    }

    //sorted by start nod,  if repeat,sorted by isUp
    private static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.pos != o2.pos) {
                return o1.pos - o2.pos; //ascend by pos
            }
            //the same position
            if (o1.isUp != o2.isUp) { //相同的位置下, 上的排在前面
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }


    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        Node[] node = new Node[2 * buildings.length];     // each building to two message
        for (int i = 0; i < buildings.length; i++) {
            node[i * 2] = new Node(buildings[i][0], buildings[i][2], true); //up
            node[i * 2 + 1] = new Node(buildings[i][1], buildings[i][2], false);// down
        }
        Arrays.sort(node, new NodeComparator()); //sorted by start
        TreeMap<Integer, Integer> htMap = new TreeMap<>(); // key : height ; value : times
        TreeMap<Integer, Integer> pmMap = new TreeMap<>(); // key : pos(every) ; value : maxHeight
        for (int i = 0; i < node.length; i++) {
            if (node[i].isUp) {  //if it's up
                if (!htMap.containsKey(node[i].h)) {
                    htMap.put(node[i].h, 1);
                } else {
                    htMap.put(node[i].h, htMap.get(node[i].h) + 1); //add the times
                }
            } else { // down
                if (!htMap.containsKey(node[i].h)) continue;
                if (htMap.get(node[i].h) == 1) {
                    htMap.remove(node[i].h);
                } else {
                    htMap.put(node[i].h, htMap.get(node[i].h) - 1);
                }
            }

            if (htMap.isEmpty()) {
                pmMap.put(node[i].pos, 0);
            } else {
                pmMap.put(node[i].pos, htMap.lastKey()); //存入当前位置和的当前的最大高度
            }
        }

        //根据pmMap 构造出轮廓
        List<List<Integer>> res = new ArrayList<>();
        int start = 0, height = 0; //一开始 = 0
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int maxHeight = entry.getValue();

            if (height != maxHeight) {  //发现改变  有轮廓
                if (height != 0) {  //这个是第一个要判断一下
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start); //起点
                    temp.add(curPosition); //当前的
                    temp.add(height);
                    res.add(temp);
                }
                start = curPosition;
                height = maxHeight;
            }
        }
        return res;
    }
}
