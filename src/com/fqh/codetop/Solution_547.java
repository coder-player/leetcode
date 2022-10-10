package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/7 23:10:49
 * 547. 省份数量
 * <p>
 * <p>
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 */
public class Solution_547 {

    public static void main(String[] args) {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));

    }

    //并查集的联通分量
    public static int findCircleNum(int[][] isConnected) {
        UnionFind find = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) { //直接相连的城市进行合并
                    find.union(i, j);
                }
            }
        }
        return find.getCount(); //返回的连通分量就是省份数量
    }

    static class UnionFind {
        private int count; //联通分量
        private int[] parent; //记录每个节点的父节点

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            //初始化所有节点的parent都为自身
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            this.count = n; //初始化都未联通
        }

        //一直寻找父亲节点的值
        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        //判断两个节点是否连通【同一个父亲节点】
        public boolean isConnect(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            return pRoot == qRoot;
        }

        //将两个节点连通
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) { //已经联通了
                return;
            }
            parent[qRoot] = pRoot; //将其中任意一个节点指向另一个节点的父节点
            count--; //连通分量减少一个
        }

        public int getCount() {
            return count;
        }
    }
}
