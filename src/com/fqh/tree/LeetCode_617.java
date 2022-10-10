package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/21 23:05:36
 */

import com.fqh.util.TreeNode;

/**
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 */
public class LeetCode_617 {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;

        TreeNode root2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node33 = new TreeNode(4);
        TreeNode node44 = new TreeNode(7);
        root2.left = node11;
        root2.right = node22;
        node11.right = node33;
        node22.right = node44;

        TreeNode root = new LeetCode_617().mergeTrees(root1, root2);
        System.out.println(root);

    }

    //DFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return root;
    }
}
