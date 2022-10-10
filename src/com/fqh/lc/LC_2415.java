package com.fqh.lc;

import com.fqh.util.TreeNode;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/22 13:32:16
 */
public class LC_2415 {

    public static void main(String[] args) {

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }

    public void dfs(TreeNode node1, TreeNode node2, int depth) {
        if (node1 == null) {
            return;
        }
        if (depth % 2 != 0) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        dfs(node1.left, node2.right, depth + 1);
        dfs(node1.right, node2.left, depth + 1);
    }

}
