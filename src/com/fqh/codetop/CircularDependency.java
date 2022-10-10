package com.fqh.codetop;

import java.util.*;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/31 23:45:28
 * codeTop补充题: 检测循环依赖
 */
public class CircularDependency {

    public static void main(String[] args) {

//        int[][] relation = {
//                {0, 2},
//                {1, 2},
//                {2, 3},
//                {2, 4}
//        };
        int[][] relation = {
                {1, 0},
                {2, 0},
                {4, 0},
                {3, 1},
                {3, 4},
                {2, 4}
        };
        int nodeNums = 5;

//        System.out.println(hasCircularDependency(relation, nodeNums));
//        List<Integer> bfsList = bfs(relation, nodeNums, new ArrayList<>());
        System.out.println(bfs(relation, nodeNums, null));
    }

    static boolean hasCycle = false;

    static char[] nodes = {'A', 'B', 'C', 'D', 'E'};

    public static List<Integer> hasCircularDependency(int[][] relation, int nodeNums) {

        List<Integer>[] graph = helper(relation, nodeNums);
        List<Integer> resultPath = new ArrayList<>();
        boolean[] isVisited = new boolean[nodeNums];
        boolean[] path = new boolean[nodeNums];
        for (int i = 0; i < nodeNums; i++) {
            dfs(i, graph, isVisited, path, resultPath);
        }
        if (hasCycle) {
            return new ArrayList<>();
        }
        Collections.reverse(resultPath);
        return resultPath;
    }

    /**
     * dfs检测
     *
     * @param start      出发点
     * @param graph      关系图
     * @param resultPath 结果路径
     * @param isVisited  记录是否访问节点
     * @param path       记录是否走到了已经存在当前路径里面的路径【形成环】
     */
    public static void dfs(int start, List<Integer>[] graph,
                           boolean[] isVisited, boolean[] path,
                           List<Integer> resultPath) {

        if (path[start]) {
            hasCycle = true;
            return;
        }
        if (isVisited[start] || hasCycle) {
            return;
        }
        isVisited[start] = true;
        path[start] = true;
        for (int next : graph[start]) {
            dfs(next, graph, isVisited, path, resultPath);
        }
        resultPath.add(start);
    }

    //bfs环形检测
    public static boolean bfs(int[][] relation, int nodeNums, List<Integer> resultPath) {
        List<Integer>[] graph = helper(relation, nodeNums);
        int[] indegree = new int[nodeNums];
        for (int[] edge : relation) {
            int from = edge[1];
            int to = edge[0];
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodeNums; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int start = queue.poll();
            count++;
            for (int next : graph[start]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count != nodeNums;
    }

    public static List<Integer>[] helper(int[][] relation, int nodeNums) {
        List<Integer>[] graph = new LinkedList[nodeNums];
        for (int i = 0; i < nodeNums; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] link : relation) {
            int from = link[1];
            int to = link[0];
            graph[from].add(to);
        }
        return graph;
    }

}
