package com.fqh.codetop;

import java.util.*;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/29 23:15:39
 * 210.课程表II[拓扑排序]
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_210 {

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;

        int[] ints = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ints));
    }

    static boolean hasCycle = false;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses]; //记录是否走过该节点
        boolean[] path = new boolean[numCourses]; //记录蛇身【正在行走的路径】
        List<Integer>[] graph = helper(numCourses, prerequisites);
        List<Integer> res = new ArrayList<>();
        //图中可能存在不相邻的节点【需要对每个节点进行遍历】
        for (int i = 0; i < numCourses; i++) {
            dfs(i, graph, isVisited, path, res);
        }
        //存在环
        if (hasCycle) {
            return new int[]{};
        }
        /**
         * 反转后序遍历的结果就是一个学习顺序, 二叉树的后序遍历类似
         * 想要完成root节点需要先访问子节点
         */
        Collections.reverse(res);
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void dfs(int start, List<Integer>[] graph,
                           boolean[] isVisited, boolean[] path, List<Integer> res) {
        //贪吃蛇吃到自己[形成环]
        if (path[start]) {
            hasCycle = true;
            return;
        }
        //已经走过这个点
        if (isVisited[start] || hasCycle) {
            return;
        }
        isVisited[start] = true;
        path[start] = true;
        for (int t : graph[start]) {
            dfs(t, graph, isVisited, path, res);
        }
        //将走过的路径加入res
        res.add(start);
        path[start] = false;
    }

    //构建邻接表
    public static List<Integer>[] helper(int numCourses, int[][] prerequisites) {
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
