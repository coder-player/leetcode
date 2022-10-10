package com.fqh.lc;

import com.fqh.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/7 15:28:41
 */
public class LCP_Team2 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;

        System.out.println(new LCP_Team2().expandBinaryTree(root));
    }

    //AC
    // BFS
    public TreeNode expandBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    TreeNode x = new TreeNode(-1);
                    TreeNode temp = node.left;
                    node.left = x;
                    x.left = temp;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    TreeNode y = new TreeNode(-1);
                    TreeNode temp = node.right;
                    node.right = y;
                    y.right = temp;
                }
            }
        }
        return root;
    }
}
