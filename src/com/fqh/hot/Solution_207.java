package com.fqh.hot;

import java.util.*;

/**
 * @author 海盗狗
 * @version 1.0
 * 207. 课程表 (DFS)
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；
 * 并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class Solution_207 {

    static boolean hasCycle;

    public static void main(String[] args) {
//        学习 1课程前需要学习0, 学习0课程前需要学习2, 学习2课程前需要学习1, 形成环
        int[][] prerequisites = {{1, 0}, {0, 2}, {2, 1}};
        int numCourse = 3;
        System.out.println(canFinish(numCourse, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
//        记录是否走回路[走过该点]
        boolean[] isVisited = new boolean[numCourses];
/** @记录是否形成环状,例如a标记为true-->依赖b,b标记为true-->依赖c,标记为true-->依赖a,a已经为true,形成环[不可能完成]*/
        boolean[] path = new boolean[numCourses];
//        图中可能存没有邻节点的点,需要每个点都执行一次dfs
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, isVisited, path, i);
        }
        return !hasCycle;
    }

    //    dfs遍历图是否存在环
    public static void dfs(List<Integer>[] graph, boolean[] isVisited, boolean[] path, int start) {
        if (path[start]) {
            hasCycle = true;
        }
//        存在环就不遍历了
        if (isVisited[start] || hasCycle) {
            return;
        }
//        标记
        isVisited[start] = true;
        path[start] = true;
        for (int t : graph[start]) {
            dfs(graph, isVisited, path, t);
        }
//        将走过的点重新设置为false
        path[start] = false;
    }

    //    构建邻接表
    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] link : prerequisites) {
            int from = link[1];
            int to = link[0];
            graph[from].add(to);
        }
        return graph;
    }

}
