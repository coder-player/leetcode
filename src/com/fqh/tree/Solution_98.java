package com.fqh.tree;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/26 23:32:08
 */

import com.fqh.util.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class Solution_98 {

    public static void main(String[] args) {

    }

    long max = Long.MIN_VALUE;

    // [1, 2, 3]
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        // 当前节点比前面节点最大值还小的话 就不是二叉搜索树
        if (root.val > max) {
            max = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }

}
