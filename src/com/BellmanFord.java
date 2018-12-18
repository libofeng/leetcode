package com;

import java.util.Scanner;

public class BellmanFord {
    public long[] result;       //用于存放第0个顶点到其它顶点之间的最短距离

    //内部类，表示图的一条加权边
    class edge {
        public int a;   //边的起点
        public int b;   //边的终点
        public int value;  //边的权值

        edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

    //返回第0个顶点到其它所有顶点之间的最短距离
    public boolean getShortestPaths(int n, edge[] A) {
        result = new long[n];
        for (int i = 1; i < n; i++)
            result[i] = Integer.MAX_VALUE;  //初始化第0个顶点到其它顶点之间的距离为无穷大，此处用Integer型最大值表示
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < A.length; j++) {
                if (result[A[j].b] > result[A[j].a] + A[j].value)
                    result[A[j].b] = result[A[j].a] + A[j].value;
            }
        }
        boolean judge = true;
        for (int i = 1; i < n; i++) {   //判断给定图中是否存在负环
            if (result[A[i].b] > result[A[i].a] + A[i].value) {
                judge = false;
                break;
            }
        }
        return judge;
    }

    public static void main(String[] args) {
        BellmanFord test = new BellmanFord();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个图的顶点总数n和边总数p：");
        int n = in.nextInt();
        int p = in.nextInt();
        edge[] A = new edge[p];
        System.out.println("请输入具体边的数据：");
        for (int i = 0; i < p; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int value = in.nextInt();
            A[i] = test.new edge(a, b, value);
        }
        if (test.getShortestPaths(n, A)) {
            for (int i = 0; i < test.result.length; i++)
                System.out.print(test.result[i] + " ");
        } else
            System.out.println("给定图存在负环，没有最短距离");
    }
}
