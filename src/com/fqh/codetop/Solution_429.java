package com.fqh.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fqh.util.Node;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/5/2 22:28:24
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 */
public class Solution_429 {

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

        System.out.println(levelOrder(root));
    }

    //bfs
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node == null) {
                    break;
                }
                list.add(node.val);
                if (node.children != null) { //子节点列表不为null，入队列
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
