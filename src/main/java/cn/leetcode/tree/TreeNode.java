package cn.leetcode.tree;

/**
 * @author gaowenjin
 * @date 2020/11/5
 * @description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(TreeNode left, TreeNode right, int x) {
        this.left = left;
        this.right = right;
        this.val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
