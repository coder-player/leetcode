package com.fqh.codetop;

import com.fqh.util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/2 22:49:52
 * 559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */
public class Solution_559 {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        List<Node> children1 = new ArrayList<>();
        children1.add(node1);
        children1.add(node2);
        children1.add(node3);
        root.children = children1;

        List<Node> children2 = new ArrayList<>();
        children2.add(node4);
        children2.add(node5);
        node1.children = children2;

        System.out.println(maxDepth(root));
    }

    //bfs
    public static int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node == null) {
                    break;
                }
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            maxDepth++; //遍历一层深度 + 1
        }
        return maxDepth;
    }

    //dfs TODO

}
