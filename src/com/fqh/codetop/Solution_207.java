package com.fqh.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/29 00:26:30
 * 207. 课程表 [DFS]
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
