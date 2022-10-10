package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/4 23:06:49
 */

import com.fqh.util.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class LeetCode_236 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        TreeNode commonAncestor = new LeetCode_236().lowestCommonAncestor(root, p, q);
        System.out.println(commonAncestor);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 遇到 p q就向上返回
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        // 最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 不为null就向上返回
        return left == null ? right : left;
    }
}
